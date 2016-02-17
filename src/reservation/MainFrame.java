
package reservation;


import java.awt.BorderLayout;

import java.awt.Button;

import java.awt.Frame;

import java.awt.HeadlessException;

import java.awt.Label;

import java.awt.Panel;

import java.awt.TextArea;

import java.awt.TextField;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import java.awt.event.WindowEvent;

import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MainFrame extends Frame implements ActionListener,WindowListener,KeyListener{


    ReservationControl reservationControl;

    Panel panelNorth;         //�㕔�p�l��

    Panel panelNorthSub1;     //�㕔�p�l���̏�

    Panel panelNorthSub2;     //�㕔�p�l���̒���

    Panel panelNorthSub3;     //�㕔�p�l���̉�

    Panel panelMid;            //�����p�l��

    Panel panelSouth;        //�����p�l��


    Button buttonLog;        // ���O�C�� �E ���O�A�E�g�{�^��

    Button buttonExplanation;    // �{�݊T�v�����{�^��

    Button buttonVacancy;    // �󂫏󋵊m�F

    Button buttonReservation;    // �V�K�\��{�^��

    Button buttonConfirm;    // �\��̊m�F

    Button buttonCancel;    // �\��̃L�����Z���{�^��


    ChoiceFacility choiceFacility;    // �{�ݑI��p�I���{�b�N�X

    TextField tfYear, tfMonth, tfDay;    //�N�����̃e�L�X�g�t�B�[���h

    TextArea textMessage;    // ���ʕ\���p���b�Z�[�W��


    

    public MainFrame(ReservationControl reservationControl) throws HeadlessException {

        this.reservationControl = reservationControl;

        // �{�^���̐���

        buttonLog = new Button("���O�C��");

        buttonExplanation = new Button(" �{�݊T�v");

        buttonVacancy = new Button(" �󂫏󋵊m�F");

        buttonReservation = new Button(" �V�K�\��");

        buttonConfirm = new Button(" �\��̊m�F");

        buttonCancel = new Button(" �\��̃L�����Z��");

        

        // �ݔ��`���C�X�{�b�N�X�̐���

        choiceFacility = new ChoiceFacility();

        tfYear = new TextField("",4);

        tfMonth = new TextField("",2);

        tfDay = new TextField("",2);


        // �㒆���̃p�l�����g������,���C�A�E�g�}�l�[�W���[��BorderLayout��ݒ�

        setLayout( new BorderLayout());


        // �㕔�p�l���̏�p�l���� �\��V�X�e�� �Ƃ������x���� [���O�C��]�{�^����ǉ�

        panelNorthSub1 = new Panel();

        panelNorthSub1.add(new Label("�{�ݗ\��V�X�e�� "));

        panelNorthSub1.add(buttonLog);


        // �㕔�p�l���̒����p�l���� �{��[�{�ݖ��I��]�`���C�X[�T�v����]�{�^����ǉ�

        panelNorthSub2 = new Panel();

        panelNorthSub2.add(new Label("�{�� "));

        panelNorthSub2.add( choiceFacility);

        panelNorthSub2.add(new Label(" "));

        panelNorthSub2.add( buttonExplanation);


        // �㕔�p�l���̉��p�l���ɔN�������͗��� �󂫏󋵊m�F�{�^����ǉ�

        panelNorthSub3 = new Panel();

        panelNorthSub3.add(new Label(" "));

        panelNorthSub3.add(tfYear);

        panelNorthSub3.add(new Label("�N"));

        panelNorthSub3.add(tfMonth);

        panelNorthSub3.add(new Label("��"));

        panelNorthSub3.add(tfDay);

        panelNorthSub3.add(new Label("�� "));

        panelNorthSub3.add( buttonVacancy);


        // �㕔�p�l����3�̃p�l����ǉ�

        panelNorth = new Panel(new BorderLayout());

        panelNorth.add(panelNorthSub1, BorderLayout.NORTH);

        panelNorth.add(panelNorthSub2, BorderLayout.CENTER);

        panelNorth.add(panelNorthSub3, BorderLayout.SOUTH);


        // ���C�����(MainFrame)�ɏ㕔�p�l����ǉ�

        add(panelNorth,BorderLayout.NORTH);


        // �����p�l���Ƀe�L�X�g���b�Z�[�W����ݒ�

        panelMid = new Panel();

        textMessage = new TextArea( 20, 80);

        textMessage.setEditable(false);

        panelMid.add(textMessage);


        // ���C�����(MainFrame)�ɒ����p�l����ǉ�

        add( panelMid,BorderLayout.CENTER);


        // �����p�l���Ƀ{�^����ݒ�

        panelSouth = new Panel();

        panelSouth.add(buttonReservation);

        panelSouth.add(new Label(" "));

        panelSouth.add(buttonConfirm);

        panelSouth.add(new Label(" "));

        panelSouth.add(buttonCancel);


        // ���C�����(MainFrame)�ɉ����p�l����ǉ�

        add( panelSouth,BorderLayout.SOUTH);


        //�{�^���̃A�N�V�������X�i�̒ǉ�

        buttonLog.addActionListener(this);

        buttonExplanation.addActionListener(this);

        buttonVacancy.addActionListener(this);

        buttonReservation.addActionListener(this);

        buttonConfirm.addActionListener(this);

        buttonCancel.addActionListener(this);



        addWindowListener(this);

        addKeyListener(this);

    }


    @Override

    public void keyTyped(KeyEvent e) {

        // TODO Auto-generated method stub

        

    }


    @Override

    public void keyPressed(KeyEvent e) {

        // TODO Auto-generated method stub

        

    }


    @Override

    public void keyReleased(KeyEvent e) {

        // TODO Auto-generated method stub

        

    }


    @Override

    public void windowOpened(WindowEvent e) {

        // TODO Auto-generated method stub

        

    }


    @Override

    public void windowClosing(WindowEvent e) {

        // TODO Auto-generated method stub

        System.exit(0);

        

    }


    @Override

    public void windowClosed(WindowEvent e) {

        // TODO Auto-generated method stub

        

    }


    @Override

    public void windowIconified(WindowEvent e) {

        // TODO Auto-generated method stub

        

    }


    @Override

    public void windowDeiconified(WindowEvent e) {

        // TODO Auto-generated method stub

        

    }


    @Override

    public void windowActivated(WindowEvent e) {

        // TODO Auto-generated method stub

        

    }


    @Override

    public void windowDeactivated(WindowEvent e) {

        // TODO Auto-generated method stub

        

    }


    @Override

    public void actionPerformed(ActionEvent e) {

        // TODO Auto-generated method stub

    	String result = new String();

        textMessage.setText("");

        if ( e.getSource() == buttonVacancy){ // �󂫏󋵊m�F�{�^��

            result = reservationControl.getReservationOn(choiceFacility.getSelectedItem(), tfYear.getText(), tfMonth.getText(), tfDay.getText());
            
        }

        else if (e.getSource() == buttonLog){

            result = reservationControl.loginLogout(this);
            		

        }

        else if (e.getSource() == buttonReservation){

            result = reservationControl.makeReservation(this);
            

        }
        
       
        else if (e.getSource() == buttonConfirm) {

        		String reult = "";
            	ResultSet rs;
            	MySQL mysql = new MySQL();
            	
            	rs = mysql.selectAll();

            	try {
					while(rs.next()){
						int cid = rs.getInt("reservation_id");
						
						String cfacility = rs.getString("facility_name"); 
								
						String cdate = rs.getString("date");		

					    String cstart = rs.getString("start_time");

					    String cend = rs.getString("end_time");

					    result +=  cid + " " + cfacility + ":" + cdate + " " + cstart + "--" + cend + "\n";

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
        	     	
        }
        
        else if (e.getSource() == buttonCancel) {
        	result = reservationControl.cancelReservation(this);
        }
        
        else if (e.getSource() == buttonExplanation) {
        	result = reservationControl.getExp(choiceFacility.getSelectedItem());

        	
        }
        
        textMessage.setText(result);

}
    
}
    
