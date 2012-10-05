package morlok8k.MinecraftLandGenerator.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import morlok8k.MinecraftLandGenerator.var;

/**
 * 
 * @author morlok8k
 */
public class MLG_GUI {

	final Font arial = new Font("Arial", Font.PLAIN, 12);
	final Font arialBold = new Font("Arial", Font.BOLD, 12);

	public JFrame frmMLG_GUI;

	JButton btnStart;
	JButton btnStop;

	JFormattedTextField txtSizeX;
	JFormattedTextField txtSizeZ;

	JFormattedTextField txtCPX;
	JFormattedTextField txtCPZ;

	JProgressBar pgbTotPer;
	JProgressBar pgbCurPer;

	JLabel lblTotPer;
	JLabel lblCurPer;

	JRadioButton rdbtnSizeSquarify;
	JRadioButton rdbtnSizeCustomSize;

	JRadioButton rdbtnAlignRegions;
	JRadioButton rdbtnAlignChunks;

	JRadioButton rdbtnCenterSpawnPoint;
	JRadioButton rdbtnCenterOther;

	JLabel lblTimeRem;
	JLabel lblCurLoc;
	JLabel lblCurStatus;

	JLabel lblSizeZ;
	JLabel lblSizeX;

	JLabel lblCPX;
	JLabel lblCPZ;
	JMenuItem mntmStart;
	JMenuItem mntmStop;
	JCheckBoxMenuItem chckbxmntmImportCustomList;

	/**
	 * Create the application.
	 */
	public MLG_GUI() {

		var.UsingGUI = true;

		// Program-wide UI stuff here...
		MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (final Exception e) {
			e.printStackTrace();
		}

		UIManager.put("Button.font", arial);
		UIManager.put("ToggleButton.font", arial);
		UIManager.put("RadioButton.font", arial);
		UIManager.put("CheckBox.font", arial);
		UIManager.put("ColorChooser.font", arial);
		UIManager.put("ComboBox.font", arial);
		UIManager.put("Label.font", arial);
		UIManager.put("List.font", arial);
		UIManager.put("MenuBar.font", arial);
		UIManager.put("MenuItem.font", arial);
		UIManager.put("RadioButtonMenuItem.font", arial);
		UIManager.put("CheckBoxMenuItem.font", arial);
		UIManager.put("Menu.font", arial);
		UIManager.put("PopupMenu.font", arial);
		UIManager.put("OptionPane.font", arial);
		UIManager.put("Panel.font", arial);
		UIManager.put("ProgressBar.font", arial);
		UIManager.put("ScrollPane.font", arial);
		UIManager.put("Viewport.font", arial);
		UIManager.put("TabbedPane.font", arial);
		UIManager.put("Table.font", arial);
		UIManager.put("TableHeader.font", arial);
		UIManager.put("TextField.font", arial);
		UIManager.put("PasswordField.font", arial);
		UIManager.put("TextArea.font", arial);
		UIManager.put("TextPane.font", arial);
		UIManager.put("EditorPane.font", arial);
		UIManager.put("TitledBorder.font", arial);
		UIManager.put("ToolBar.font", arial);
		UIManager.put("ToolTip.font", arial);
		UIManager.put("Tree.font", arial);

		// End Look and Feel code

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// Frame:
		frmMLG_GUI = new JFrame();
		frmMLG_GUI.setResizable(false);
		frmMLG_GUI.setBounds(100, 100, 475, 400);
		frmMLG_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMLG_GUI.setVisible(true);
		frmMLG_GUI.getContentPane().setLayout(new BorderLayout(0, 0));

		// Menu Bar:
		final JMenuBar menuBar = new JMenuBar();
		frmMLG_GUI.setJMenuBar(menuBar);

		// Top Level Menus:
		final JMenu mnFile = new JMenu("File");
		final JMenu mnInfo = new JMenu("Info");
		final JMenu mnHelp = new JMenu("Help");

		// File Menu Objects:
		mntmStart = new JMenuItem("Start");
		mntmStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent arg0) {

				start_GUI();
			}
		});

		mntmStop = new JMenuItem("Stop");
		mntmStop.setEnabled(false);
		mntmStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				stop_GUI();
			}
		});

		final JSeparator hzlFile1 = new JSeparator();

		chckbxmntmImportCustomList = new JCheckBoxMenuItem("Import Custom List");
		chckbxmntmImportCustomList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ImportCustomList();

			}
		});
		chckbxmntmImportCustomList.setEnabled(false);

		final JSeparator hzlFile2 = new JSeparator();

		final JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent arg0) {

				Exit();

			}
		});
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));

		// Info Menu Objects:
		final JMenuItem mntmMapInfo = new JMenuItem("Map Info");
		mntmMapInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				MapInfo();
			}
		});

		// Help Menu Objects:
		final JMenuItem mntmAboutMlg = new JMenuItem("About MLG");
		mntmAboutMlg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				AboutMLG();
			}
		});

		final JSeparator hzlHelp1 = new JSeparator();

		final JMenuItem mntmUpdateMlg = new JMenuItem("Update MLG");
		mntmUpdateMlg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				UpdateMLG();
			}
		});

		// Create Menu Bar:
		menuBar.add(mnFile);
		menuBar.add(mnInfo);
		menuBar.add(mnHelp);

		// File:
		mnFile.add(mntmStart);
		mnFile.add(mntmStop);
		mnFile.add(hzlFile1);
		mnFile.add(chckbxmntmImportCustomList);
		mnFile.add(hzlFile2);
		mnFile.add(mntmExit);

		// Info:
		mnInfo.add(mntmMapInfo);

		// Help:
		mnHelp.add(mntmAboutMlg);
		mnHelp.add(hzlHelp1);
		mnHelp.add(mntmUpdateMlg);

		// NumberFormats
		final NumberFormat nfSizeInt = NumberFormat.getIntegerInstance();
		nfSizeInt.setParseIntegerOnly(true);
		final NumberFormat nfCPInt = NumberFormat.getIntegerInstance();
		nfCPInt.setParseIntegerOnly(true);

		// Create Main Panels, Interior Panels, and Objects...
		// TODO: Refactor this clusterf*ck!
		final JPanel mainWest = new JPanel(new BorderLayout());
		final JPanel mainEast = new JPanel(new BorderLayout());
		final JPanel mainSouth = new JPanel(new BorderLayout());
		final JPanel mainNorth = new JPanel(new BorderLayout());

		mainSouth.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Progress:"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		// Create Interior Panels
		final JPanel pnlStartStop = new JPanel(new BorderLayout());
		final JPanel pnlStatus = new JPanel();
		pnlStatus.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Status:"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				start_GUI();

			}
		});
		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				stop_GUI();

			}
		});
		btnStop.setEnabled(false);

		final JLabel lblMinecraftLandGenerator = new JLabel("Minecraft Land Generator");
		lblMinecraftLandGenerator.setFont(new Font("Arial", Font.BOLD, 14));
		lblMinecraftLandGenerator.setHorizontalAlignment(SwingConstants.CENTER);

		// Add Objects to interior panels

		mainNorth.add(lblMinecraftLandGenerator, BorderLayout.CENTER);

		pnlStartStop.add(btnStart, BorderLayout.LINE_START);
		pnlStartStop.add(btnStop, BorderLayout.LINE_END);

		// Add interior panels to Main panels

		mainWest.add(pnlStartStop, BorderLayout.NORTH);

		final Component horizontalStrutStartStop = Box.createHorizontalStrut(25);
		pnlStartStop.add(horizontalStrutStartStop, BorderLayout.CENTER);
		mainWest.add(pnlStatus, BorderLayout.CENTER);
		pnlStatus.setLayout(null);

		final JLabel lblCurrentStatus = new JLabel("Current Status:");
		lblCurrentStatus.setBounds(12, 12, 118, 15);
		pnlStatus.add(lblCurrentStatus);
		lblCurrentStatus.setFont(arialBold);

		lblCurStatus = new JLabel("Idle");
		lblCurStatus.setBounds(12, 24, 118, 15);
		pnlStatus.add(lblCurStatus);
		lblCurStatus.setHorizontalAlignment(SwingConstants.RIGHT);

		final JLabel lblCurrentLocation = new JLabel("Current Location:");
		lblCurrentLocation.setBounds(12, 48, 118, 15);
		pnlStatus.add(lblCurrentLocation);
		lblCurrentLocation.setFont(arialBold);

		lblCurLoc = new JLabel("[0,0,0]");
		lblCurLoc.setBounds(12, 60, 118, 15);
		pnlStatus.add(lblCurLoc);
		lblCurLoc.setHorizontalAlignment(SwingConstants.RIGHT);

		final JLabel lblTimeRemaining = new JLabel("Time Remaining:");
		lblTimeRemaining.setBounds(12, 84, 118, 15);
		pnlStatus.add(lblTimeRemaining);
		lblTimeRemaining.setFont(arialBold);

		lblTimeRem = new JLabel("0 Seconds");
		lblTimeRem.setBounds(12, 96, 118, 15);
		pnlStatus.add(lblTimeRem);
		lblTimeRem.setHorizontalAlignment(SwingConstants.RIGHT);

		// add Main panels to Top-Level Panel

		frmMLG_GUI.getContentPane().add(mainNorth, BorderLayout.NORTH);
		frmMLG_GUI.getContentPane().add(mainWest, BorderLayout.WEST);
		frmMLG_GUI.getContentPane().add(mainEast, BorderLayout.EAST);

		final JPanel pnlOptions = new JPanel();
		mainEast.add(pnlOptions, BorderLayout.CENTER);
		pnlOptions.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Options:"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		pnlOptions.setLayout(new BorderLayout(0, 0));

		final JPanel pnlSize = new JPanel();
		pnlSize.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Size:"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		pnlOptions.add(pnlSize, BorderLayout.NORTH);
		pnlSize.setLayout(new BorderLayout(0, 0));

		final JPanel pnlSizeX = new JPanel();
		pnlSize.add(pnlSizeX, BorderLayout.WEST);
		pnlSizeX.setLayout(new BorderLayout(0, 0));

		lblSizeX = new JLabel("X: ");
		pnlSizeX.add(lblSizeX, BorderLayout.WEST);

		txtSizeX = new JFormattedTextField(nfSizeInt);
		txtSizeX.setFont(arial);
		txtSizeX.setText("1000");
		pnlSizeX.add(txtSizeX, BorderLayout.EAST);
		txtSizeX.setColumns(7);

		final JPanel pnlSizeZ = new JPanel();
		pnlSize.add(pnlSizeZ, BorderLayout.EAST);
		pnlSizeZ.setLayout(new BorderLayout(0, 0));

		lblSizeZ = new JLabel(" Z: ");
		pnlSizeZ.add(lblSizeZ, BorderLayout.WEST);

		txtSizeZ = new JFormattedTextField(nfSizeInt);
		txtSizeZ.setFont(arial);
		txtSizeZ.setText("1000");
		txtSizeZ.setColumns(7);
		pnlSizeZ.add(txtSizeZ, BorderLayout.EAST);

		final JPanel pnlSizeXZ = new JPanel();
		pnlSize.add(pnlSizeXZ, BorderLayout.NORTH);
		pnlSizeXZ.setLayout(new BorderLayout(0, 0));

		rdbtnSizeCustomSize = new JRadioButton("Custom Size:");
		rdbtnSizeCustomSize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				SizeSetEnable(true);
			}
		});

		rdbtnSizeCustomSize.setSelected(true);
		pnlSizeXZ.add(rdbtnSizeCustomSize, BorderLayout.CENTER);

		final JPanel pnlSizeSquarify = new JPanel();
		pnlSize.add(pnlSizeSquarify, BorderLayout.SOUTH);
		pnlSizeSquarify.setLayout(new BorderLayout(0, 0));

		rdbtnSizeSquarify = new JRadioButton("Squarify Existing Land");
		rdbtnSizeSquarify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				SizeSetEnable(false);
			}
		});
		pnlSizeSquarify.add(rdbtnSizeSquarify, BorderLayout.CENTER);

		final JPanel pnlCenterPoint = new JPanel();
		pnlCenterPoint.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Center Point:"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		pnlOptions.add(pnlCenterPoint, BorderLayout.CENTER);
		pnlCenterPoint.setLayout(new BorderLayout(0, 0));

		final JPanel pnlCPrb = new JPanel();
		pnlCenterPoint.add(pnlCPrb, BorderLayout.NORTH);
		pnlCPrb.setLayout(new BorderLayout(0, 0));

		rdbtnCenterSpawnPoint = new JRadioButton("Spawn Point");
		rdbtnCenterSpawnPoint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				txtCPX.setEnabled(false);
				txtCPZ.setEnabled(false);
				lblCPX.setEnabled(false);
				lblCPZ.setEnabled(false);
			}
		});
		rdbtnCenterSpawnPoint.setSelected(true);
		pnlCPrb.add(rdbtnCenterSpawnPoint, BorderLayout.WEST);

		rdbtnCenterOther = new JRadioButton("Other:");
		rdbtnCenterOther.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				txtCPX.setEnabled(true);
				txtCPZ.setEnabled(true);
				lblCPX.setEnabled(true);
				lblCPZ.setEnabled(true);
			}
		});
		pnlCPrb.add(rdbtnCenterOther, BorderLayout.EAST);

		final ButtonGroup bgCenterPoint = new ButtonGroup();
		bgCenterPoint.add(rdbtnCenterSpawnPoint);
		bgCenterPoint.add(rdbtnCenterOther);

		final JPanel pnlCPSelection = new JPanel();
		pnlCenterPoint.add(pnlCPSelection, BorderLayout.SOUTH);
		pnlCPSelection.setLayout(new BorderLayout(0, 0));

		final JPanel pnlCPx = new JPanel();
		pnlCPSelection.add(pnlCPx, BorderLayout.WEST);
		pnlCPx.setLayout(new BorderLayout(0, 0));

		lblCPX = new JLabel("X: ");
		lblCPX.setEnabled(false);
		pnlCPx.add(lblCPX, BorderLayout.WEST);

		txtCPX = new JFormattedTextField(nfCPInt);
		txtCPX.setFont(arial);
		txtCPX.setEnabled(false);
		txtCPX.setText("0");
		pnlCPx.add(txtCPX, BorderLayout.EAST);
		txtCPX.setColumns(7);

		final JPanel pnlCPz = new JPanel();
		pnlCPSelection.add(pnlCPz, BorderLayout.EAST);
		pnlCPz.setLayout(new BorderLayout(0, 0));

		lblCPZ = new JLabel("Z: ");
		lblCPZ.setEnabled(false);
		pnlCPz.add(lblCPZ, BorderLayout.WEST);

		txtCPZ = new JFormattedTextField(nfCPInt);
		txtCPZ.setEnabled(false);
		txtCPZ.setFont(arial);
		txtCPZ.setText("0");
		pnlCPz.add(txtCPZ, BorderLayout.EAST);
		txtCPZ.setColumns(7);

		final JPanel pnlAlignment = new JPanel();
		pnlAlignment.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Alignment:"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		pnlOptions.add(pnlAlignment, BorderLayout.SOUTH);
		pnlAlignment.setLayout(new BorderLayout(0, 0));

		rdbtnAlignChunks = new JRadioButton("Chunks");
		rdbtnAlignChunks.setSelected(true);
		pnlAlignment.add(rdbtnAlignChunks, BorderLayout.WEST);

		rdbtnAlignRegions = new JRadioButton("Regions");
		pnlAlignment.add(rdbtnAlignRegions, BorderLayout.EAST);

		final ButtonGroup bgAlignment = new ButtonGroup();

		bgAlignment.add(rdbtnAlignChunks);
		bgAlignment.add(rdbtnAlignRegions);

		final ButtonGroup bgSize = new ButtonGroup();
		bgSize.add(rdbtnSizeCustomSize);
		bgSize.add(rdbtnSizeSquarify);

		frmMLG_GUI.getContentPane().add(mainSouth, BorderLayout.SOUTH);

		final JPanel pnlCurPrg = new JPanel();
		mainSouth.add(pnlCurPrg, BorderLayout.NORTH);
		pnlCurPrg.setLayout(new BorderLayout(0, 0));

		final JLabel lblCurrentProgress = new JLabel("Current Progress: ");
		pnlCurPrg.add(lblCurrentProgress, BorderLayout.WEST);

		lblCurPer = new JLabel("100%");
		pnlCurPrg.add(lblCurPer, BorderLayout.EAST);

		pgbCurPer = new JProgressBar();
		pnlCurPrg.add(pgbCurPer, BorderLayout.CENTER);

		final JPanel pnlTotPrg = new JPanel();
		mainSouth.add(pnlTotPrg, BorderLayout.SOUTH);
		pnlTotPrg.setLayout(new BorderLayout(0, 0));

		final JLabel lblTotalProgress = new JLabel("Total Progress: ");
		pnlTotPrg.add(lblTotalProgress, BorderLayout.WEST);

		lblTotPer = new JLabel("100%");
		pnlTotPrg.add(lblTotPer, BorderLayout.EAST);

		pgbTotPer = new JProgressBar();
		pnlTotPrg.add(pgbTotPer, BorderLayout.CENTER);

		// Frame size and location
		frmMLG_GUI.pack();
		frmMLG_GUI.setLocationRelativeTo(null);

		// Finished creation of frame
	}

	void start_GUI() {

		// TODO: add additional start code

		btnStop.setEnabled(true);
		btnStart.setEnabled(false);

		mntmStop.setEnabled(true);
		mntmStart.setEnabled(false);

		SizeSetEnable(false);
		CenterPointSetEnable(false);

		rdbtnSizeSquarify.setEnabled(false);
		rdbtnSizeCustomSize.setEnabled(false);

		rdbtnAlignRegions.setEnabled(false);
		rdbtnAlignChunks.setEnabled(false);

		rdbtnCenterSpawnPoint.setEnabled(false);
		rdbtnCenterOther.setEnabled(false);

	}

	void stop_GUI() {

		// TODO: add additional stop code

		if (rdbtnSizeCustomSize.isSelected()) {
			SizeSetEnable(true);
		} else {
			SizeSetEnable(false);
		}

		if (rdbtnCenterSpawnPoint.isSelected()) {
			CenterPointSetEnable(false);
		} else {
			CenterPointSetEnable(true);
		}

		rdbtnSizeSquarify.setEnabled(true);
		rdbtnSizeCustomSize.setEnabled(true);

		rdbtnAlignRegions.setEnabled(true);
		rdbtnAlignChunks.setEnabled(true);

		rdbtnCenterSpawnPoint.setEnabled(true);
		rdbtnCenterOther.setEnabled(true);

		mntmStop.setEnabled(false);
		mntmStart.setEnabled(true);

		btnStart.setEnabled(true);
		btnStop.setEnabled(false);

	}

	void MapInfo() {

		// TODO: Display Map Info

	}

	void AboutMLG() {

		// TODO: Display MLG About box

	}

	static void UpdateMLG() {

		// Update.updateMLG();

		Exit();
	}

	void ImportCustomList() {

		// TODO: add Import Custom List

		// TODO: disable/enable size objects

	}

	static void Exit() {

		// TODO: Make sure everything has finished...

		// Lets Exit!
		System.exit(0);

	}

	void SizeSetEnable(final boolean enabled) {

		txtSizeX.setEnabled(enabled);
		txtSizeZ.setEnabled(enabled);
		lblSizeX.setEnabled(enabled);
		lblSizeZ.setEnabled(enabled);

	}

	void CenterPointSetEnable(final boolean enabled) {

		txtCPX.setEnabled(enabled);
		txtCPZ.setEnabled(enabled);
		lblCPX.setEnabled(enabled);
		lblCPZ.setEnabled(enabled);

	}

}
