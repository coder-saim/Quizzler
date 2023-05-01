package frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import backend.Quiz;
import backend.View;


public class MainMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 4074500268726614700L;
	
	private JButton btnQuizEditor;
	private JButton btnHostGame;
	private JButton btnJoinGame;
	private JButton btnShowAbout;
	private JButton btnQuit;
	private JPanel contentPane;

	private Main main;

	private Quiz chosenQuiz;

	public MainMenu(Main main) {
		this.main = main;
		this.contentPane = (JPanel) getContentPane();
		setTitle("Quizzler");
		setBounds(500, 120, 1150, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(0xffffff));


		UI();




	}

	public Quiz getQuiz() {
		return chosenQuiz;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnQuizEditor) {
			main.showView(View.QUIZ_EDITOR);
		} else if (e.getSource() == btnHostGame) {
			if (main.serverIsRunning()) {
				JOptionPane.showMessageDialog(null, "Server is already running");
				return;
			}
			JFileChooser jfc = new JFileChooser();
			if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				try {
					chosenQuiz = Quiz.read(jfc.getSelectedFile().getAbsolutePath());
					main.showView(View.SERVER_MODE);
				} catch (ClassNotFoundException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Failed to load quiz from file");
				}
			}
		} else if (e.getSource() == btnJoinGame) {
			main.showView(View.CLIENT_MODE);
		} else if (e.getSource() == btnShowAbout) {
			main.showView(View.ABOUT_WINDOW);
		} else if (e.getSource() == btnQuit) {
			System.exit(0);
		}
	}

	void UI(){


		btnQuizEditor = new JButton("Quiz Editor");
		btnQuizEditor.addActionListener(this);
		btnQuizEditor.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		btnQuizEditor.setForeground(new Color(46, 139, 87));
		btnQuizEditor.setBackground(new Color(250, 250, 210));
		btnQuizEditor.setBounds(70, 200, 150, 25);
		contentPane.add(btnQuizEditor);



		btnHostGame = new JButton("Host Game");
		btnHostGame.addActionListener(this);
		btnHostGame.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		btnHostGame.setForeground(new Color(46, 139, 87));
		btnHostGame.setBackground(new Color(250, 250, 210));
		btnHostGame.setBounds(70, 310, 150, 25);
		contentPane.add(btnHostGame);

		btnJoinGame = new JButton("Join Game");
		btnJoinGame.addActionListener(this);
		btnJoinGame.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		btnJoinGame.setForeground(new Color(46, 139, 87));
		btnJoinGame.setBackground(new Color(250, 250, 210));
		btnJoinGame.setBounds(70, 410, 150, 25);
		contentPane.add(btnJoinGame);

		btnShowAbout = new JButton("About Quizzler");
		btnShowAbout.addActionListener(this);
		btnShowAbout.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		btnShowAbout.setForeground(new Color(46, 139, 87));
		btnShowAbout.setBackground(new Color(250, 250, 210));
		btnShowAbout.setBounds(60, 510, 170, 25);
		contentPane.add(btnShowAbout);

		btnQuit = new JButton("Quit");
		btnQuit.addActionListener(this);
		btnQuit.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		btnQuit.setForeground(new Color(46, 139, 87));
		btnQuit.setBackground(new Color(250, 250, 210));
		btnQuit.setBounds(70, 610, 150, 25);
		contentPane.add(btnQuit);



		JLabel h = new JLabel("");
		ImageIcon e  = new ImageIcon("icon/horizontal.png");
		Image f = e.getImage().getScaledInstance(1150, 100,Image.SCALE_DEFAULT);
		ImageIcon g = new ImageIcon(f);
		h = new JLabel(g);
		h.setBounds(0, 0, 1150, 100);
		contentPane.add(h);


		JLabel v = new JLabel("");
		ImageIcon a  = new ImageIcon("icon/vertical.png");
		Image b = a.getImage().getScaledInstance(300, 680,Image.SCALE_DEFAULT);
		ImageIcon c = new ImageIcon(b);
		v = new JLabel(c);
		v.setBounds(0, 100, 300, 680);
		contentPane.add(v);


		JLabel j = new JLabel("");
        ImageIcon x  = new ImageIcon("icon/Library.gif");
        Image y = x.getImage().getScaledInstance(550, 550,Image.SCALE_DEFAULT);
        ImageIcon z = new ImageIcon(y);
        j = new JLabel(z);
        contentPane.add(j);


	}

}