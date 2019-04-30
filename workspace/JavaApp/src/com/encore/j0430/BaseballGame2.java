package com.encore.j0430;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
	
	<이벤트 처리> - 사건(버튼눌림, 마우스 움직임, 체크하기, 텍스트쓰기 등) 발생 시 가능(실행 문장들 기술)추가
	1. 이벤트 소스 : bt_new, bt_clear, bt_dap, bt_exit, tf
				 ---------------------------------- ---
				 			JButton				    JTextField
		        사건 :  			 버튼눌림				    텍스트 필드에 엔터가 입력  ----> Action 이벤트!
		        
	2. implements ActionListener
		 ---> actionPerformed구현
		 
	3. 연결자 등록
		버튼명.addActionListener(this);
		텍스트명.addActionListener(this);
	
 */

public class BaseballGame2 extends JFrame implements ActionListener {
	JTextArea ta;
	JTextField tf;
	JButton bt_new, bt_clear, bt_dap, bt_exit, bt_hint;
	JPanel taP, buP, tfP, tP;
	JLabel lb;
	JScrollPane scroll_ta;
	Random r;
	JFrame f;
	
	boolean start; //게임 시작 상태 표현
	
	int []com;
	int []user;
	int count;

	public BaseballGame2() {
		setTitle("숫자야구게임");
		f = this;
		
		com = new int[3];		//배열객체생성식!
		user = new int[3];		//사용자가 입력한 데이터로 초기화
		r = new Random();
		count = 0;
		
		createNum();
		
		ta = new JTextArea();
		scroll_ta = new JScrollPane(ta);
		ta.setEditable(false);
		ta.setFont(new Font("굴림체", Font.BOLD, 15));
		ta.setLineWrap(true); 	//자동줄바꿈

		tf = new JTextField(40);
		tf.setEnabled(false);

		lb = new JLabel("입력 : ");

		bt_new = new JButton("새 게임");
		bt_clear = new JButton("지우기");
		bt_hint = new JButton("힌트");
		  bt_hint.setEnabled(false);
		bt_dap = new JButton("정답");
		  bt_dap.setEnabled(false);
		bt_exit = new JButton("종료");

		taP = new JPanel();
		taP.setBackground(Color.cyan);
		taP.setLayout(new BorderLayout(10, 10));
		taP.add("North", new JLabel());
		taP.add("West", new JLabel());
		taP.add("East", new JLabel());
		taP.add("South", new JLabel());
		taP.add("Center", scroll_ta);

		tfP = new JPanel();
		tfP.setBackground(Color.cyan);
		tfP.setLayout(new FlowLayout());
		tfP.add(lb);
		tfP.add(tf);

		tP = new JPanel();
		tP.setLayout(new BorderLayout());
		tP.add("Center", taP);
		tP.add("South", tfP);

		buP = new JPanel();
		buP.setBackground(Color.cyan);
		buP.setLayout(new GridLayout(7, 1, 10, 10));
		buP.add(new Label());
		buP.add(bt_new);
		buP.add(bt_clear);
		buP.add(bt_hint);
		buP.add(bt_dap);
		buP.add(bt_exit);

		setLayout(new BorderLayout());
		add("Center", tP);
		add("East", buP);

		setBackground(Color.CYAN);
		setSize(600, 400);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tf.requestFocus();
		ruleDescription();

		eventup();	//이벤트소스 등록(이벤트소스와 이벤트 처리부 연결!)
	}
	

	private void eventup() {
		//버튼
		bt_new.addActionListener(this);		//201호
		bt_dap.addActionListener(this);		//202호
		bt_clear.addActionListener(this);	//203호
		bt_exit.addActionListener(this);	//204호
		bt_hint.addActionListener(this);	//206호
		
		tf.addActionListener(this);			//205호
		tf.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
//				JOptionPane.showMessageDialog(f, "게임 시작을 위해 [새 게임]버튼을 클릭!");
				if(!start) {
					showMsg("게임 시작을 위해 [새 게임]버튼 클릭");
				}
			}
			
		});
		/*
			this ---> JFrame X
			this ---> MouseAdapter O
		 */
		//텍스트 필드
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		//가장 빈번한 이벤트 발생 컴포넌트를 가장 위에 위치.
		Object ob = e.getSource();
		if(ob == tf) {//텍스트 필드에 enter입력 시
			//사용자가 입력한 String과 com배열의 값을 비교하여 화면(TextArea)에 결과 출력
			String str = tf.getText();	//"123"(문자열로 받아짐) ---> {1,2,3} 변환한다면 비교 용이!
			
			//str의 유효성 검사!
			if(!str.matches("[\\d]{3}")) {
				showMsg("세자리 숫자만 입력!");
				tf.setText("");
				return;
			}
			
			for (int i = 0; i < user.length; i++) {
				user[i] = str.charAt(i)-48;
			}
			
			if(duplicateNum()) {
				showMsg("중복된 숫자 사용 금지!");
				tf.setText("");
				return;
			}
			
			count++;
			//int su = Integer.parseInt(str);		//"123" ---> 123
			/*
				su/100;			---> 123/100 	  ---> 1
				(su%100)/10;	---> (123%100)/10 ---> 2
				(su%100)%10;	---> (123%100)%10 ---> 3
			*/
			
			/*
			   user[0] = su/100; user[1] = (su%100)/10; user[2] = (su%100)%10;
			*/
			
			//==> com배열과 비교할 수 있는 대등한 int[]user 배열 값이 생성
			int strike = 0, ball = 0;
			//비교
			for (int i = 0; i < com.length; i++) {//com배열 인덱스
				for (int j = 0; j < user.length; j++) {//user배열 인덱스
					//같은 수가 존재한다면 ==> 스트라이크 또는 볼 후보
					if(com[i] == user[j]) {//같은 수 발견
						if(i == j) {//같은 자릿수 발견
							strike++;//같은 수, 같은 자리
						}else {
							ball++;  //같은 수 , 다른 자리
						}
					}
				}//안쪽 for
			}//바깥 for
			
			//9번의 비교가 끝난 후 결과 출력
			if(strike == 3) {
				ta.append("★축하합니다★ 정답(" + str + ")을 맞추셨습니다!\n" );
				tf.setEditable(false);
			}else {				
				ta.append(count + " : " + str + " ▶ " + strike + " Strike " + ball + " Ball\n" );
			}
			
			tf.setText("");
			
		}else if(ob == bt_new) {//'새게임' 버튼 클릭시
//			ta.setText("\t\t ★게임 시작!★\n");
//			bt_dap.setEnabled(true);
//			bt_hint.setEnabled(true);
//			tf.setEditable(true);
//			tf.requestFocus();
//			count = 0;
//			createNum();
			
			startGame();
			
		}else if(ob == bt_dap) {//'정답' 버튼 클릭시
			//com배열의 값을 ta에 출력
			endGame();
			ta.append("★정답은 [" + com[0] + com[1] + com[2] + "]입니다.\n");  //append = String
		}else if(ob == bt_clear) {
			ta.setText("");
			tf.setText("");
		}else if(ob == bt_hint) {
			int i = r.nextInt(3);
			JOptionPane.showMessageDialog(this, "Hint : " + (i+1) + "번째 수는 '" +com[i]+"' 입니다.\n");
			//ta.append("Hint : " + (i+1) + "번째 수는 '" +com[i]+"' 입니다.\n"); 
			bt_hint.setEnabled(false);
		}else if(ob == bt_exit) {
			System.exit(0);
		}
		
	}
	
	private void createNum() {
		for (int i = 0; i < com.length; i++) {	//com배열 인덱스 표현
			com[i] = r.nextInt(10);
			for (int j = i-1; j >= 0; j--) {	//중복검사 : i = 1 --> 0번지 비교
				//         i = 2 --> 1번지 ,0번지 비교
				if (com[i] == com[j]) {	//중복된 데이터가 발견된다면
					i--;
					break;
				}//if
			}//안for
		}//밖for
	}//번호 생성
	
	public boolean duplicateNum() {
		if(user[0] == user[1] ||
		   user[0] == user[2] ||
		   user[1] == user[2]) {
			return true;
		}return false;
	}
	
	private void ruleDescription() {
		ta.append("\n\n\t\t<숫자 야구 게임>\n\n");
		ta.append("1. 게임 시작을 위해서 '새 게임'버튼을 클릭\n");
		ta.append("2. 입력에 중복되지 않는 세자리수를 입력 후 엔터\n");
		ta.append("3. 숫자와 자릿수를 맞추면 Strike, 숫자만 맞추면 Ball이 추가됩니다.\n");
		ta.append("4. 정답을 보고싶으면 '정답'버튼 클릭\n");
		ta.append("5. 기타 문의 사항이 있으면 관리자에게 연락바랍니다. :)");
	}
	
	public void showMsg(String message) {
		JOptionPane.showMessageDialog(this, message);
		
	}
	
	public void startGame() {
		createNum();
		start = true;
		tf.setEnabled(true);
		tf.requestFocus();
		ta.setText("\t\t ★게임 시작!★\n");
		count = 0;
		bt_dap.setEnabled(true);
		bt_hint.setEnabled(true);
	}
	
	public void endGame() {
		start = false;
		tf.setEnabled(false);
		bt_dap.setEnabled(false);
		bt_hint.setEnabled(false);
	}
	
	
	public static void main(String[] args) {
		new BaseballGame2();
	}

}
