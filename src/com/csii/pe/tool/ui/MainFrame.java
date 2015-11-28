package com.csii.pe.tool.ui;

import static com.csii.pe.tool.util.AssertUtils.isEmptyAssert;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.csii.pe.tool.exector.Ctx2RouterExecutor;
import com.csii.pe.tool.exector.Esb2CtxExecutor;
import com.csii.pe.tool.exector.Router2EsbExecutor;
import com.csii.pe.tool.util.ComponentUtils;
import com.csii.pe.tool.util.PropUtils;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * create window with 800px width,600px height by default
	 * 
	 * @author tzbank
	 */
	public MainFrame() {
		this(800, 600);
	}

	/**
	 * @param width
	 *            ,width of window
	 * @param length
	 * @author tzbank
	 */
	public MainFrame(int width, int length) {
		if (width <= 0 || length <= 0) {
			throw new IllegalArgumentException(
					"width and lengh args must larger than 0.");
		}
		this.setTitle(getText("frame.title"));
		this.setSize(width, length);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);// no resize
		this.setLocationRelativeTo(null);
		initComponents();
		eventProcess();
	}

	/**
	 * show window,called by client
	 * 
	 * @author tzbank
	 */
	public void showWindow() {
		this.setVisible(true);
	}

	/**
	 * init ui compontens,called by constructor
	 * 
	 * @author tzbank
	 */
	private void initComponents() {
		// add labels
		label1.setText(getText("label.text.input.msgfield"));
		cutil.setProps(label1, 140, 20, 20, 20, true);
		this.add(label1);

		label2.setText(getText("label.text.input.msgtype"));
		cutil.setProps(label2, 140, 20, 200, 20, true);
		this.add(label2);

		label3.setText(getText("label.text.input.msgcomment"));
		cutil.setProps(label3, 140, 20, 380, 20, true);
		this.add(label3);

		label4.setText(getText("label.text.info.msgtype"));
		cutil.setProps(label4, 140, 20, 550, 20, true);
		this.add(label4);

		label5.setText(getText("label.text.info.msgname"));
		cutil.setProps(label5, 140, 20, 550, 160, true);
		this.add(label5);

		label6.setText(getText("label.text.info.choosefile"));
		cutil.setProps(label6, 140, 20, 550, 220, true);
		this.add(label6);

		// add textareas
		cutil.setProps(textArea1, 140, 500, 20, 50, true);
		this.add(textArea1);

		cutil.setProps(textArea2, 140, 500, 200, 50, true);
		this.add(textArea2);

		cutil.setProps(textArea3, 140, 500, 380, 50, true);
		this.add(textArea3);

		textArea4.setAutoscrolls(true);
		textArea4.setLineWrap(true);
		textArea4.setEditable(false);
		cutil.setProps(textArea4, 200, 100, 550, 290, true);
		this.add(textArea4);
		// add button
		button1.setText(getText("button.text.genmsg"));
		cutil.setProps(button1, 120, 20, 550, 450, true);
		this.add(button1);

		button2.setText(getText("button.text.choosefile"));
		cutil.setProps(button2, 120, 20, 550, 250, true);
		this.add(button2);

		// jpanel
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		rightPanel.setSize(200, 100);
		rightPanel.setLocation(550, 50);
		rightPanel.setLayout(null);
		rightPanel.setVisible(true);
		this.add(rightPanel);
		// radio button

		radio1.setText(getText("radio.button.context2router"));
		radio1.setSelected(true);
		cutil.setProps(radio1, 150, 20, 10, 10, true);
		group1.add(radio1);
		rightPanel.add(radio1);

		radio2.setText(getText("radio.button.router2esb"));
		cutil.setProps(radio2, 150, 20, 10, 40, true);
		group1.add(radio2);
		rightPanel.add(radio2);

		radio3.setText(getText("radio.button.esb2context"));
		cutil.setProps(radio3, 150, 20, 10, 70, true);
		group1.add(radio3);
		rightPanel.add(radio3);

		// textfield
		cutil.setProps(field1, 200, 20, 550, 190, true);
		this.add(field1);

		// filechooser
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	}

	private void eventProcess() {
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				log.info("process button1 click event.");
				String msgFields = textArea1.getText();
				String msgFieldTypes = textArea2.getText();
				String msgFieldComments = textArea3.getText();// allow empty.
				String msgFilePath = textArea4.getText();
				String msgFileName = field1.getText();
				// message field must not empty.
				if (isEmptyAssert(msgFields,
						getText("msgbox.alert.please.input.msgfield")))
					return;
				// message field type must not empty.
				if (isEmptyAssert(msgFieldTypes,
						getText("msgbox.alert.please.input.msgfieldtype")))
					return;
				// must choose message file path.
				if (isEmptyAssert(msgFilePath,
						getText("msgbox.alert.please.choose.filepath")))
					return;

				if (isEmptyAssert(msgFileName,
						getText("msgbox.alert.please.input.filename")))
					return;
				
				if(radio1.isSelected())
				{
					new Ctx2RouterExecutor(msgFilePath, msgFileName, msgFields,
							msgFieldTypes, msgFieldComments);
				}else if(radio2.isSelected())
				{
					new Router2EsbExecutor(msgFilePath, msgFileName, msgFields,
							msgFieldTypes, msgFieldComments);
				}else if(radio3.isSelected())
				{
					new Esb2CtxExecutor(msgFilePath, msgFileName, msgFields,
							msgFieldTypes, msgFieldComments);
				}
				
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				log.info("process button2 click event.");
				// choose file
				int returnVal = fileChooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String strFilePath = fileChooser.getSelectedFile()
							.getAbsolutePath();
					log.info("You chose to open this file: " + strFilePath);
					textArea4.setText(strFilePath);

				}

			}
		});
	}

	private String getText(String key) {
		return props.getText(key);
	}

	private PropUtils props = new PropUtils();
	private ComponentUtils cutil = new ComponentUtils();
	private Log log = LogFactory.getLog(this.getClass());
	// label component
	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel();
	private JLabel label4 = new JLabel();
	private JLabel label5 = new JLabel();
	private JLabel label6 = new JLabel();
	// textarea component
	private JTextArea textArea1 = new JTextArea();
	private JTextArea textArea2 = new JTextArea();
	private JTextArea textArea3 = new JTextArea();
	private JTextArea textArea4 = new JTextArea();
	// button
	private JButton button1 = new JButton();
	private JButton button2 = new JButton();
	// radio button
	private ButtonGroup group1 = new ButtonGroup();
	private JRadioButton radio1 = new JRadioButton();
	private JRadioButton radio2 = new JRadioButton();
	private JRadioButton radio3 = new JRadioButton();
	// panel
	private JPanel rightPanel = new JPanel();
	// textfield
	private JTextField field1 = new JTextField();
	// filechooser
	private JFileChooser fileChooser = new JFileChooser();
}
