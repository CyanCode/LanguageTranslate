import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Actions implements ActionListener{
	private JTextArea toTranslateText;
	private JTextArea translatedText;
	private JButton toEngBtn;
	private JButton toLangBtn;
	private JButton wordsBtn;

	public Actions(JTextArea toTranslate,
			JTextArea translated,
			JButton toEng,
			JButton toLang,
			JButton words) {
		this.toTranslateText = toTranslate;
		this.translatedText = translated;
		this.toEngBtn = toEng;
		this.toLangBtn = toLang;
		this.wordsBtn = words;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == toEngBtn) {
			Dictionary dict = new Dictionary("TOENG", toTranslateText.getText());
			translatedText.setText(dict.translateSentence());
		} else if (e.getSource() == toLangBtn) {
			Dictionary dict = new Dictionary("TOLANG", toTranslateText.getText());
			translatedText.setText(dict.translateSentence());
		} else if (e.getSource() == wordsBtn) {
			try {
				java.awt.Desktop.getDesktop().browse(URI.create("http://forum.blockland.us/index.php?topic=260292.0"));
			} catch (Exception error) {
				System.out.println("Error occured while opening link: " + error);
			}
		}
	}
}
