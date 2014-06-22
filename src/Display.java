import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Display extends JApplet{
	private static final long serialVersionUID = 1L;
	private JTextArea toTranslateText;
	private JTextArea translatedText;
	private JButton toEngBtn;
	private JButton toLangBtn;
	private JButton wordsBtn;

	public Display() {
		//construct components
		toTranslateText = new JTextArea (5, 5);
		translatedText = new JTextArea (5, 5);
		toEngBtn = new JButton ("To English");
		toLangBtn = new JButton ("To Language");
		wordsBtn = new JButton ("Words");

		//adjust size and set layout
		setPreferredSize (new Dimension (447, 187));
		setLayout (null);

		//add components
		add (toTranslateText);
		add (translatedText);
		add (toEngBtn);
		add (toLangBtn);
		add (wordsBtn);

		//set component bounds (only needed by Absolute Positioning)
		toTranslateText.setBounds (10, 10, 305, 75);
		translatedText.setBounds (10, 105, 305, 75);
		toEngBtn.setBounds (325, 15, 115, 25);
		toLangBtn.setBounds (325, 50, 115, 25);
		wordsBtn.setBounds (330, 125, 100, 25);
		
		//Actions
		ActionListener action = new Actions(toTranslateText,
				translatedText, toEngBtn, toLangBtn, wordsBtn);
		wordsBtn.addActionListener(action);
		toLangBtn.addActionListener(action);
		toEngBtn.addActionListener(action);
	}
}
