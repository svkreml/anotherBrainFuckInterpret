
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

/*some brainfuck code from https://copy.sh/brainfuck/ examples and Wikipedia*/
public class Tests {
    @Test
    public void helloWorldLoops(){
        Scanner scanner = new Scanner(System.in);
        String s = BrainFuck.run(" ++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++\n" +
                " .>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.\n" +
                " ------.--------.>+.>.", null);
        Assert.assertEquals(s, "Hello World!\n");
    }

    @Test
    public void inputOutputEcho(){
        String input = "abc";
        Scanner scanner = new Scanner(input);
        String s = BrainFuck.run(",.,.,.", scanner);
        Assert.assertEquals(s, "abc");
    }

    @Test
    public void loop(){
        String input = "a";
        Scanner scanner = new Scanner(input);
        String s = BrainFuck.run(",>+++++[<.>-]", scanner);
        Assert.assertEquals(s, "aaaaa");
    }

    @Test
    public void innerLoop(){
        String input = "ab";
        Scanner scanner = new Scanner(input);
        String s = BrainFuck.run(",>,>+[-<<.>>>+[-<<.>>]<]", scanner);
        Assert.assertEquals(s, "ab");
    }

    @Test
    public void innerLoop2(){
        String input = "ab";
        Scanner scanner = new Scanner(input);
        String s = BrainFuck.run(",>,>+[-<<.>>>++[-<<.>>]<]", scanner);
        Assert.assertEquals(s, "abb");
    }

    @Test
    public void innerLoop3(){
        String input = "ab";
        Scanner scanner = new Scanner(input);
        String s = BrainFuck.run(",>,>++[-<<.>>>++[-<<.>>]<]", scanner);
        Assert.assertEquals(s, "abbabb");
    }

    @Test
    public void yapi(){
        String input = "ab";
        Scanner scanner = new Scanner(input);
        String s = BrainFuck.run(">  +++++ +++++ +++++ (15 digits)\n" +
                "\n" +
                "[<+>>>>>>>>++++++++++<<<<<<<-]>+++++[<+++++++++>-]+>>>>>>+[<<+++[>>[-<]<[>]<-]>>\n" +
                "[>+>]<[<]>]>[[->>>>+<<<<]>>>+++>-]<[<<<<]<<<<<<<<+[->>>>>>>>>>>>[<+[->>>>+<<<<]>\n" +
                ">>>>]<<<<[>>>>>[<<<<+>>>>-]<<<<<-[<<++++++++++>>-]>>>[<<[<+<<+>>>-]<[>+<-]<++<<+\n" +
                ">>>>>>-]<<[-]<<-<[->>+<-[>>>]>[[<+>-]>+>>]<<<<<]>[-]>+<<<-[>>+<<-]<]<<<<+>>>>>>>\n" +
                ">[-]>[<<<+>>>-]<<++++++++++<[->>+<-[>>>]>[[<+>-]>+>>]<<<<<]>[-]>+>[<<+<+>>>-]<<<\n" +
                "<+<+>>[-[-[-[-[-[-[-[-[-<->[-<+<->>]]]]]]]]]]<[+++++[<<<++++++++<++++++++>>>>-]<\n" +
                "<<<+<->>>>[>+<<<+++++++++<->>>-]<<<<<[>>+<<-]+<[->-<]>[>>.<<<<[+.[-]]>>-]>[>>.<<\n" +
                "-]>[-]>[-]>>>[>>[<<<<<<<<+>>>>>>>>-]<<-]]>>[-]<<<[-]<<<<<<<<]++++++++++.", scanner);
        Assert.assertEquals(s, "3.14159265358979\n");
    }

    @Test
    public void countWords(){
        String input = "ab ab dfg";
        Scanner scanner = new Scanner(input);
        String s = BrainFuck.run(">>>+>>>>>+>>+>>+[<<],[\n" +
                "    -[-[-[-[-[-[-[-[<+>-[>+<-[>-<-[-[-[<++[<++++++>-]<\n" +
                "        [>>[-<]<[>]<-]>>[<+>-[<->[-]]]]]]]]]]]]]]]]\n" +
                "    <[-<<[-]+>]<<[>>>>>>+<<<<<<-]>[>]>>>>>>>+>[\n" +
                "        <+[\n" +
                "            >+++++++++<-[>-<-]++>[<+++++++>-[<->-]+[+>>>>>>]]\n" +
                "            <[>+<-]>[>>>>>++>[-]]+<\n" +
                "        ]>[-<<<<<<]>>>>\n" +
                "    ],\n" +
                "]+<++>>>[[+++++>>>>>>]<+>+[[<++++++++>-]<.<<<<<]>>>>>>>>]", scanner);
        Assert.assertEquals(s, "\t0\t3\t9\n");
    }

    @Test
    public void selfCode(){
        String input = " +++++ +++++ +++++";
        Scanner scanner = new Scanner(input);
        String program = "-->+++>+>+>+>+++++>++>++>->+++>++>+>>>>>>>>>>>>>>>>->++++>>>>->+++>+++>+++>+++>+++>+++>+>+>>>->->>++++>+>>>>->>++++>+>+>>->->++>++>++>++++>+>++>->++>++++>+>+>++>++>->->++>++>++++>+>+>>>>>->>->>++++>++>++>++++>>>>>->>>>>+++>->++++>->->->+++>>>+>+>+++>+>++++>>+++>->>>>>->>>++++>++>++>+>+++>->++++>>->->+++>+>+++>+>++++>>>+++>->++++>>->->++>++++>++>++++>>++[-[->>+[>]++[<]<]>>+[>]<--[++>++++>]+[<]<<++]>>>[>]++++>++++[--[+>+>++++<<[-->>--<<[->-<[--->>+<<[+>+++<[+>>++<<]]]]]]>+++[>+++++++++++++++<-]>--.<<<]";
        String s = BrainFuck.run(program, scanner);
        Assert.assertEquals(s, program);
    }

    @Test
    public void helloWorld(){
        Scanner scanner = new Scanner(System.in);
        String s = BrainFuck.run(" +++++++++++++++++++++++++++++++++++++++++++++\n" +
                " +++++++++++++++++++++++++++.+++++++++++++++++\n" +
                " ++++++++++++.+++++++..+++.-------------------\n" +
                " ---------------------------------------------\n" +
                " ---------------.+++++++++++++++++++++++++++++\n" +
                " ++++++++++++++++++++++++++.++++++++++++++++++\n" +
                " ++++++.+++.------.--------.------------------\n" +
                " ---------------------------------------------\n" +
                " ----.-----------------------.", null);
        Assert.assertEquals(s, "Hello World!\n");
    }
}
