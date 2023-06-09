package frontend;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import backend.Question;


public class QuestionAnalysis extends JPanel {

	private static final long serialVersionUID = -4252183076285924502L;
	
	private Question question;
	private int answerCount[];
	

	public void loadData(Question q, int[] answers) {
		question = q;
		answerCount = answers;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if (question == null) {
			return;
		}
		
		int maxCount = 1;
		for (int count : answerCount) {
			if (count > maxCount) {
				maxCount = count;
			}
		}
		
		g.setColor(new Color(255, 102, 102));
		g.fillRect(200, 120, 300 * answerCount[0] / maxCount, 15);
		
		g.setColor(new Color(102, 102, 255));
		g.fillRect(200, 140, 300 * answerCount[1] / maxCount, 15);
		
		g.setColor(new Color(255, 255, 179));
		g.fillRect(200, 160, 300 * answerCount[2] / maxCount, 15);
		
		g.setColor(new Color(255, 191, 128));
		g.fillRect(200, 180, 300 * answerCount[3] / maxCount, 15);
		
		g.setColor(Color.BLACK);
		g.drawString(question.getQ(), 25, 80);
		g.drawString("Answers", 40, 100);
		
		int y = 120;
		int i = 0;
		for (String ans : question.getAnswers()) {
			boolean correct = question.acceptAnswer(i);
			g.drawString((correct ? "->" : "") + ans, (correct ? 85 : 90), y + 10);
			y += 20;
			i++;
		}
	}

}
