package com.github.hiteshsondhi88.libffmpeg;

import java.io.IOException;

import timber.log.Timber;

class ShellCommand {

    Process run(String[] commandString) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(commandString);
        } catch (IOException e) {
            Timber.e(e, "Exception while trying to run: %s", commandString);
        }
        return process;
    }

    CommandResult runWaitFor(String[] s) {
        Process process = run(s);

        Integer exitValue = null;
        String output = null;
        try {
            if (process != null) {
                exitValue = process.waitFor();

                if (CommandResult.success(exitValue)) {
                    output = Util.convertInputStreamToString(process.getInputStream());
                } else {
                    output = Util.convertInputStreamToString(process.getErrorStream());
                }
            }
        } catch (InterruptedException e) {
            Timber.e(e);
        } finally {
            Util.destroyProcess(process);
        }

        return new CommandResult(CommandResult.success(exitValue), output);
    }

}
