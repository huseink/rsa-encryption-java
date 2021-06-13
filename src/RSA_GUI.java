import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class RSA_GUI {

	private JFrame frame;
	private JTextField pText;
	private JTextField qText;
	private JTextField nText;
	private JTextField phiText;
	private JTextField dText;
	private JTextField eText;
	private JTextField messageText;
	private JTextField encryptedMessageText;
	private JTextField encryptionTimeText;
	private JTextField decryptedMessageText;
	private JTextField decryptionTimeText;
	private JTextField dTimeText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RSA_GUI window = new RSA_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RSA_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        RSA rsaObject = new RSA();
        
		frame = new JFrame();
		frame.setBounds(100, 100, 831, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton calculateNBtn = new JButton("Calculate N and Phi(N)");
		
		calculateNBtn.setBounds(37, 115, 198, 23);
		frame.getContentPane().add(calculateNBtn);
		
		JLabel lblNewLabel = new JLabel("P:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(37, 24, 19, 14);
		frame.getContentPane().add(lblNewLabel);
		
		pText = new JTextField();
		pText.setBounds(105, 21, 130, 20);
		frame.getContentPane().add(pText);
		pText.setColumns(10);
		
		qText = new JTextField();
		qText.setColumns(10);
		qText.setBounds(105, 69, 130, 20);
		frame.getContentPane().add(qText);
		
		JLabel lblQ = new JLabel("Q:");
		lblQ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQ.setBounds(37, 72, 19, 14);
		frame.getContentPane().add(lblQ);
		
		nText = new JTextField();
		nText.setEditable(false);
		nText.setColumns(10);
		nText.setBounds(490, 24, 211, 20);
		frame.getContentPane().add(nText);
		
		JLabel lblN = new JLabel("N:");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblN.setBounds(385, 27, 74, 14);
		frame.getContentPane().add(lblN);
		
		phiText = new JTextField();
		phiText.setEditable(false);
		phiText.setColumns(10);
		phiText.setBounds(490, 69, 211, 20);
		frame.getContentPane().add(phiText);
		
		JLabel lbln = new JLabel("\u03B8(N):");
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbln.setBounds(385, 72, 91, 14);
		frame.getContentPane().add(lbln);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 174, 211, 116);
		frame.getContentPane().add(scrollPane);
		
		JList possibleExponents = new JList();
		possibleExponents.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(possibleExponents);
		
		JLabel lblPossibleEValues = new JLabel("E list:");
		lblPossibleEValues.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPossibleEValues.setBounds(37, 177, 36, 14);
		frame.getContentPane().add(lblPossibleEValues);
		
		JLabel lblD = new JLabel("D:");
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblD.setBounds(37, 417, 74, 14);
		frame.getContentPane().add(lblD);
		
		dText = new JTextField();
		dText.setEditable(false);
		dText.setColumns(10);
		dText.setBounds(83, 415, 211, 20);
		frame.getContentPane().add(dText);
		
		eText = new JTextField();
		eText.setColumns(10);
		eText.setBounds(83, 312, 211, 20);
		frame.getContentPane().add(eText);
		
		JLabel lblE_1 = new JLabel("E:");
		lblE_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblE_1.setBounds(37, 314, 19, 14);
		frame.getContentPane().add(lblE_1);
		
		JButton calculateDBtn = new JButton("Calculate D");
		
		calculateDBtn.setBounds(83, 352, 211, 23);
		frame.getContentPane().add(calculateDBtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 149, 585, 14);
		frame.getContentPane().add(separator);
		
		JLabel lblE_1_1 = new JLabel("Message:");
		lblE_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblE_1_1.setBounds(385, 176, 101, 14);
		frame.getContentPane().add(lblE_1_1);
		
		messageText = new JTextField();
		messageText.setColumns(10);
		messageText.setBounds(490, 174, 211, 20);
		frame.getContentPane().add(messageText);
		
		JButton encDecBtn = new JButton("Encrpyt & Decrpyt Message");
		
		encDecBtn.setBounds(490, 217, 211, 23);
		frame.getContentPane().add(encDecBtn);
		
		encryptedMessageText = new JTextField();
		encryptedMessageText.setEditable(false);
		encryptedMessageText.setColumns(10);
		encryptedMessageText.setBounds(490, 268, 211, 20);
		frame.getContentPane().add(encryptedMessageText);
		
		JLabel lblEncryptedMessage = new JLabel("Encrypted Message:");
		lblEncryptedMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEncryptedMessage.setBounds(330, 270, 146, 14);
		frame.getContentPane().add(lblEncryptedMessage);
		
		encryptionTimeText = new JTextField();
		encryptionTimeText.setEditable(false);
		encryptionTimeText.setColumns(10);
		encryptionTimeText.setBounds(490, 311, 211, 20);
		frame.getContentPane().add(encryptionTimeText);
		
		JLabel lblEncryptTime = new JLabel("Encryption Time:");
		lblEncryptTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEncryptTime.setBounds(330, 313, 146, 14);
		frame.getContentPane().add(lblEncryptTime);
		
		decryptedMessageText = new JTextField();
		decryptedMessageText.setEditable(false);
		decryptedMessageText.setColumns(10);
		decryptedMessageText.setBounds(490, 350, 211, 20);
		frame.getContentPane().add(decryptedMessageText);
		
		JLabel lblEncryptedMessage_1 = new JLabel("Decrypted Message:");
		lblEncryptedMessage_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEncryptedMessage_1.setBounds(330, 352, 146, 14);
		frame.getContentPane().add(lblEncryptedMessage_1);
		
		decryptionTimeText = new JTextField();
		decryptionTimeText.setEditable(false);
		decryptionTimeText.setColumns(10);
		decryptionTimeText.setBounds(490, 391, 211, 20);
		frame.getContentPane().add(decryptionTimeText);
		
		JLabel lblDecryptionTime = new JLabel("Decryption Time:");
		lblDecryptionTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDecryptionTime.setBounds(330, 393, 146, 14);
		frame.getContentPane().add(lblDecryptionTime);
		
		dTimeText = new JTextField();
		dTimeText.setEditable(false);
		dTimeText.setColumns(10);
		dTimeText.setBounds(109, 453, 185, 20);
		frame.getContentPane().add(dTimeText);
		
		JLabel lblDCalculationTime = new JLabel("D Time:");
		lblDCalculationTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDCalculationTime.setBounds(37, 455, 112, 14);
		frame.getContentPane().add(lblDCalculationTime);
		
		
		calculateNBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Set p and q values of rsaObject
				rsaObject.setP(new BigInteger(pText.getText()));
				rsaObject.setQ(new BigInteger(qText.getText()));
				nText.setText(rsaObject.calculateN().toString());
				phiText.setText(rsaObject.calculatePhi().toString());
				
				// Set possible e values
				possibleExponents.setListData(rsaObject.possibleExponentValues().toArray());
			}
		});
		
		calculateDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rsaObject.setE(new BigInteger(eText.getText()));
				long time_1 = System.nanoTime();
				BigInteger d = rsaObject.generateKeys();
				long time_2 = System.nanoTime();
				dText.setText(d.toString());
				long difference = time_2 - time_1;
				dTimeText.setText(difference + " nanoseconds");
			}
		});
		
		encDecBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Encrypt
				String message = messageText.getText();
				long encStart = System.nanoTime();
				BigInteger encryptedText = rsaObject.encrpytMessage(new BigInteger(message));
				long encEnd = System.nanoTime();
				long encDifferenceInTime = encEnd - encStart;
				encryptedMessageText.setText(encryptedText.toString());
				encryptionTimeText.setText(encDifferenceInTime + " nanoseconds");
				
				// Decrypt
				long decStart = System.nanoTime();
				BigInteger decryptedText = rsaObject.decrpytMessage();
				long decEnd = System.nanoTime();
				long decDifferenceInTime = decEnd - decStart;
				decryptedMessageText.setText(decryptedText.toString());
				decryptionTimeText.setText(decDifferenceInTime + " nanoseconds");
			}
		});
	}
}
