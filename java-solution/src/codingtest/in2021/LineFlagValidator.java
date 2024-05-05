package codingtest.in2021;

import java.util.*;

class Command {
    private final String flag;
    private final String argument;

    public Command(String flag, String argument) {
        this.flag = flag;
        this.argument = argument;
    }

    public String getFlag() {
        return flag;
    }

    public String getArgument() {
        return argument;
    }
}

class Validator {
    Map<String, String> flagRuleMap = new HashMap<>();

    public Validator(List<Command> rule) {
        initializeRule(rule);
    }

    private void initializeRule(List<Command> commands) {
        for (Command command : commands) {
            flagRuleMap.put(command.getFlag(), command.getArgument());
        }
    }

    public boolean validate(List<Command> commands) {
        boolean isValid = true;

        for (Command command : commands) {
            if (command.getFlag() != null && command.getArgument() == null) {
                return false;
            }

            try {
                String args = flagRuleMap.get(command.getFlag());
                System.out.println(args);

                if (args.equals("NUMBER")) {
                    try {
                        Integer.parseInt(command.getArgument());
                    } catch (NumberFormatException e) {
                        return false;
                    }
                }

                if (args.equals("NULL")) {
                    if (!command.getArgument().equals("null")) {
                        return false;
                    }
                }

            } catch (NullPointerException e) {
                return false;
            }


        }

        return isValid;
    }
}

class Parser {
    private String program;

    public String getProgram() {
        return program;
    }

    public Command parseRule(String flagRule) {
        String[] flagRules = flagRule.split(" ");

        return new Command(flagRules[0], flagRules[1]);
    }

    public List<Command> parseCommand(String command) {
        String[] commands = command.split(" ");
        this.program = commands[0];

        List<Command> flagArguments = new ArrayList<>();

        int i = 1;
        for (i = 1; i < commands.length - 1; i += 2) {
            flagArguments.add(new Command(commands[i], commands[i + 1]));
        }
        if (commands.length == 1) {
            flagArguments.add(new Command(commands[1], "null"));
        }
        if (i != commands.length) {
            flagArguments.add(new Command(commands[commands.length - 1], "null"));
        }

        return flagArguments;
    }
}

class LineFlagValidatorSolution {
    public boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];
        Parser parser = new Parser();
        List<Command> flagRuleList = new ArrayList<>();

        for (String flag_rule : flag_rules) {
            Command command = parser.parseRule(flag_rule);
            flagRuleList.add(command);
        }

        Validator validator = new Validator(flagRuleList);

        int i = 0;
        for (String command : commands) {
            List<Command> commandList = parser.parseCommand(command);

            System.out.println("program : " + parser.getProgram());
            for (Command cmd : commandList) {
                System.out.println(cmd.getFlag() + " " + cmd.getArgument());
            }
            System.out.println();

            if (program.equals(parser.getProgram())) {
                answer[i++] = validator.validate(commandList);
            } else {
                answer[i++] = false;
            }

        }

        return answer;
    }
}

public class LineFlagValidator {
    public static void main(String[] args) {
        LineFlagValidatorSolution sol = new LineFlagValidatorSolution();
        System.out.println(Arrays.toString(sol.solution("line", new String[]{"-s STRING", "-n NUMBER", "-e NULL"}, new String[]{"line -n 100 -s hi -e", "lien -s Bye"})));
        System.out.println();
        System.out.println(Arrays.toString(sol.solution("line", new String[]{"-s STRING", "-n NUMBER", "-e NULL"}, new String[]{"line -s 123 -n HI", "line fun"})));
    }

}
