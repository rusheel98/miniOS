package osProject;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import java.io.*;
import java.util.*;



class TestTerminal extends JFrame
{
	private static final long serialVersionUID = 1L;
    public static void main(String[] args) {
        Terminal term = Terminal.getInstance();
        term.open(0, 0, 700, 700);
    }
}

public class Terminal {
    private JFrame frm = new JFrame("Terminal");
    private JTextArea txtArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane();
    private CommandProcessor processor = CommandProcessor.getInstance();
    private final String LINE_SEPARATOR = System.lineSeparator();
    private Font font = new Font("SansSerif", Font.BOLD, 15);
    private static int count=0;

    private Terminal() {
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm.getContentPane().add(scrollPane);
        scrollPane.setViewportView(txtArea);
        txtArea.addKeyListener(new KeyListener());
        txtArea.setFont(font);
        disableArrowKeys(txtArea.getInputMap());
    }

    private void disableArrowKeys(InputMap inputMap) {
        String[] keystrokeNames = { "UP", "DOWN", "LEFT", "RIGHT", "HOME" };
        for (int i = 0; i < keystrokeNames.length; ++i)
            inputMap.put(KeyStroke.getKeyStroke(keystrokeNames[i]), "none");
    }

    public void open(final int xLocation, final int yLocation, final int width,
            final int height) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
            	  frm.setBounds(xLocation, yLocation, width, height);
                  frm.setVisible(true);
                  frm.setState(JFrame.NORMAL);
                  showPrompt();
            }
                  
        });
    }

    public void close() {
        frm.dispose();
    }

    public void clear() {
        txtArea.setText("");
        showPrompt();
    }

    private void showPrompt() {
        txtArea.setText(txtArea.getText() + "> ");
    }

    private void showNewLine() {
        txtArea.setText(txtArea.getText() + LINE_SEPARATOR);
    }

    private class KeyListener extends KeyAdapter {
        private final int ENTER_KEY = KeyEvent.VK_ENTER;
        private final int BACK_SPACE_KEY = KeyEvent.VK_BACK_SPACE;
        private final String BACK_SPACE_KEY_BINDING = getKeyBinding(
                txtArea.getInputMap(), "BACK_SPACE");
        private final int INITIAL_CURSOR_POSITION = 2;

        private boolean isKeysDisabled;
        private int minCursorPosition = INITIAL_CURSOR_POSITION;

        private String getKeyBinding(InputMap inputMap, String name) {
            return (String) inputMap.get(KeyStroke.getKeyStroke(name));
        }

        public void keyPressed(KeyEvent evt) {
            int keyCode = evt.getKeyCode();
            if (keyCode == BACK_SPACE_KEY) {
                int cursorPosition = txtArea.getCaretPosition();
                if (cursorPosition == minCursorPosition && !isKeysDisabled) {
                    disableBackspaceKey();
                } else if (cursorPosition > minCursorPosition && isKeysDisabled) {
                    enableBackspaceKey();
                }
            } else if (keyCode == ENTER_KEY) {
                disableTerminal();
                String command = extractCommand();
                if(command.equals("exit"))
                {
                    close();
                }
                else if(command.equals("clear"))
                {
                	clear();
                	enableTerminal();
                }
                else
                {
                	  executeCommand(command);
                      showNewLine();
                      showPrompt();
                      enableTerminal();	
                }
            }
        }

        public void keyReleased(KeyEvent evt) {
            int keyCode = evt.getKeyCode();
            if (keyCode == ENTER_KEY) {
                txtArea.setCaretPosition(txtArea.getCaretPosition()-1);
                setMinCursorPosition();
            }
        }

        private void disableBackspaceKey() {
            isKeysDisabled = true;
            txtArea.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"),
                    "none");
        }

        private void enableBackspaceKey() {
            isKeysDisabled = false;
            txtArea.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"),
                    BACK_SPACE_KEY_BINDING);
        }

        private void setMinCursorPosition() {
            minCursorPosition = txtArea.getCaretPosition();
        }
    }

    public void enableTerminal() {
        txtArea.setEnabled(true);
    }

    public void disableTerminal() {
        txtArea.setEnabled(false);
    }

    private void executeCommand(String command) {
    	try {
        BufferedReader br = processor.processCmd(command);
        String line;
        while ((line = br.readLine()) != null)
        { 	
            txtArea.append(line+"\n");
            //System.out.println(line); 
        }
        
        }
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    private String extractCommand() {
    	removeLastLineSeparator();
        String newCommand = stripPreviousCommands();
        count++;
        return newCommand;
    }

    private void removeLastLineSeparator() {
        String terminalText = txtArea.getText();
        terminalText = terminalText.substring(0, terminalText.length());
        txtArea.setText(terminalText);
    }

    private String stripPreviousCommands() {    	
        String terminalText = txtArea.getText();
        int lastPromptIndex = terminalText.lastIndexOf('>') + 2;
        if (lastPromptIndex < 0 || lastPromptIndex >= terminalText.length())
        {
          return "";
        }
        else
        {
        String str;
            if(count==0)
             	 str = terminalText.substring(lastPromptIndex);
            else
                 str = terminalText.substring(lastPromptIndex,terminalText.lastIndexOf('\n'));
            return str;
        }
    }

    public static Terminal getInstance() {
        return TerminalHolder.INSTANCE;
    }

    private static final class TerminalHolder {
        static final Terminal INSTANCE = new Terminal();       
    }
}

class CommandProcessor {
    private CommandProcessor() {
    }

    public  BufferedReader processCmd(String command) {
    	BufferedReader br = null;
        try
        {
        
        ArrayList<String> parms = new ArrayList<String>();
        String[] lineSplit = command.split(" ");
        
        int size = lineSplit.length;
        for (int i=0; i<size; i++) {
            parms.add(lineSplit[i]); 
        }
        
        ProcessBuilder pb = new ProcessBuilder(parms);
        Process proc = pb.start();  
        
        // obtain the input stream
        InputStream is = proc.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
         br = new BufferedReader(isr);      
      
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        return br;
    }

    public static CommandProcessor getInstance() {
        return CommandProcessorHolder.INSTANCE;
    }

    private static final class CommandProcessorHolder {
        static final CommandProcessor INSTANCE = new CommandProcessor();
    }
    
    public static void main(String[] args) {
        Terminal term = Terminal.getInstance();
        term.open(0, 0, 700, 700);
    }
    
}
