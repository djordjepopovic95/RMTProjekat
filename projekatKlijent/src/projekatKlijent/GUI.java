package projekatKlijent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JPanel pnlLevi;
	private JPanel pnlPolja;
	private JButton btnFsadf;
	private JButton button_1;
	private JButton button_2;
	private JButton btnNewButton;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	private JButton button_16;
	private JButton button_17;
	private JButton button_18;
	private JButton button_19;
	private JButton button_20;
	private JButton button_21;
	private JButton button_22;
	private JButton button_23;
	private JButton button_24;
	private JButton button_25;
	private JButton button_26;
	private JButton button_27;
	private JButton button_28;
	static JButton dugme = null;

	private static int matrica[][] = new int[10][10];
	public static boolean naPotezu = false;
	//public boolean aktivan = false;

	static Socket socketZaKomunikaciju = null;
	static PrintStream izlazniTokKaServeru = null;
	static BufferedReader ulazniTokOdServera = null;

	static boolean kraj = false;

	public static GUI frame;
	private JPanel panel;
	private JTextArea konzolaIspis;
	private JTextArea konzolaUnos;
	static Component[] components;
	private JButton button_30;
	private JButton button;
	private JButton button_29;
	private JButton btnNewButton_1;
	private JButton button_31;
	private JButton button_32;
	private JButton button_33;
	private JButton button_34;
	private JButton button_35;
	private JButton button_36;
	private JButton button_37;
	private JButton button_38;
	private JButton button_39;
	private JButton button_40;
	private JButton button_41;
	private JButton button_42;
	private JButton button_43;
	private JButton button_44;
	private JButton button_45;
	private JButton button_46;
	private JButton button_47;
	private JButton button_48;
	private JButton button_49;
	private JButton button_50;
	private JButton button_51;
	private JButton button_52;
	private JButton button_53;
	private JButton button_54;
	protected JButton button_55;
	private JButton button_56;
	private JButton button_57;
	private JButton button_58;
	private JButton button_59;
	private JButton btnNewButton_2;
	private JButton button_60;
	private JButton button_61;
	private JButton button_62;
	private JButton button_63;
	private JButton button_64;
	private JButton button_65;
	private JButton button_66;
	private JButton button_67;
	private JButton button_68;
	private JButton button_69;
	private JButton button_70;
	private JButton button_71;
	private JButton button_72;
	private JButton button_73;
	private JButton button_74;
	private JButton button_75;
	private JButton btnOdustajem;
	private JButton button_76;
	private JButton button_77;
	private JButton button_78;
	private JButton button_79;
	private JButton button_80;
	private JButton button_81;
	private JButton button_82;
	private JButton button_83;
	private JButton button_84;
	private JButton button_85;
	private JButton button_86;
	private JButton button_87;
	private JButton button_88;
	private JButton button_89;
	private JButton button_90;
	private JButton button_91;
	private JButton button_92;
	private JButton button_93;
	private JButton button_94;
	private JButton button_95;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		String linijaOdServera;
		konektujSe();
		try {

			while ((linijaOdServera = ulazniTokOdServera.readLine()) != null) {
				frame.konzolaIspis.setText(linijaOdServera + "\n");

				if (linijaOdServera.equals("pobedio si")) {
					kraj = true;
					JOptionPane.showMessageDialog(frame, "Pobedio/la si! :)", "Kraj igre",
							JOptionPane.INFORMATION_MESSAGE);
					izlazniTokKaServeru.println("pobedio sam");
					socketZaKomunikaciju.close();
					return;
				}

				if (linijaOdServera.equals("na potezu")) {
					GUI.naPotezu = true;
				} else {

					if (linijaOdServera.charAt(0) != 'n') {
						for (Component c : components) {
							if (c.getName().equals(linijaOdServera)) {
								dugme = (JButton) c;
								System.out.println(dugme.getName());
								break;
							}
						}

						if (dugme != null && dugme.getBackground() != new Color(62, 230, 194)
								&& dugme.getBackground() != new Color(230, 62, 98)) {

							dugme.setBackground(new Color(62, 230, 194));
							System.out.println("USAO U NIT");
							dugme.setForeground(new Color(62, 230, 194));
							dugme.setVisible(true);
							dugme.setContentAreaFilled(true);
							dugme.setOpaque(true);

						}

						int i = linijaOdServera.charAt(0);
						int j = linijaOdServera.charAt(1);
						i = i - '0';
						j = j - '0';
						if (matrica[i][j] == 0) {
							matrica[i][j] = 2;
							System.out.println(
									"primljeno od servera: " + linijaOdServera.charAt(0) + linijaOdServera.charAt(1));
						}
						System.out.println(
								"prva koordinata " + i + " druga koordinata " + j + " vrednost: " + matrica[i][j]);

						int br2 = 0;
						for (int k = 0; k < 10; k++) { //redovi
							for (int l = 0; l < 9; l++) {
								if (matrica[k][l] == 2 && matrica[k][l + 1] == 2) {
									br2++;
									if (br2 == 4) {
										izlazniTokKaServeru.println("protivnik je pobedio");
										kraj = true;
										JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
												JOptionPane.ERROR_MESSAGE);
										socketZaKomunikaciju.close();
										return;
									}
								} else {
									br2 = 0;
								}
							}
							br2 = 0;
						}

						br2 = 0;
						for (int k = 0; k < 10; k++) { //kolone
							for (int l = 0; l < 9; l++) {
								if (matrica[l][k] == 2 && matrica[l + 1][k] == 2) {
									br2++;
									if (br2 == 4) {
										izlazniTokKaServeru.println("protivnik je pobedio");
										kraj = true;
										JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
												JOptionPane.ERROR_MESSAGE);
										socketZaKomunikaciju.close();
										return;
									}
								} else {
									br2 = 0;
								}
							}
							br2 = 0;
						}

						br2 = 0;
						int br2s = 0;
						int br2g = 0;
						for (int l = 0; l < 9; l++) {
							if (matrica[l][l] == 2 && matrica[l + 1][l + 1] == 2) {
								br2g++;
								if (br2g == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2g = 0;
							}

							if (matrica[l][10 - l - 1] == 2 && matrica[l + 1][10 - l - 1 - 1] == 2) {
								br2s++;
								if (br2s == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2s = 0;
							}
						}
						int br2izg1 = 0;
						int br2iss1 = 0;
						for (int l = 0; l < 8; l++) {
							if (matrica[l][l + 1] == 2 && matrica[l + 1][l + 2] == 2) {
								br2izg1++;
								if (br2izg1 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2izg1 = 0;
							}

							if (matrica[l + 1][10 - l - 1] == 2 && matrica[l + 2][10 - l - 1 - 1] == 2) {
								br2iss1++;
								if (br2iss1 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2iss1 = 0;
							}
						}

						int br2izg2 = 0;
						int br2iss2 = 0;

						for (int l = 0; l < 7; l++) {
							if (matrica[l][l + 2] == 2 && matrica[l + 1][l + 3] == 2) {
								br2izg2++;
								if (br2izg2 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2izg2 = 0;
							}

							if (matrica[l + 2][10 - l - 1] == 2 && matrica[l + 3][10 - l - 1 - 1] == 2) {
								br2iss2++;
								if (br2iss2 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2iss2 = 0;
							}
						}

						int br2izg3 = 0;
						int br2iss3 = 0;

						for (int l = 0; l < 6; l++) {
							if (matrica[l][l + 3] == 2 && matrica[l + 1][l + 4] == 2) {
								br2izg3++;
								if (br2izg3 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2izg3 = 0;
							}

							if (matrica[l + 3][10 - l - 1] == 2 && matrica[l + 4][10 - l - 1 - 1] == 2) {
								br2iss3++;
								if (br2iss3 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2iss3 = 0;
							}
						}

						int br2izg4 = 0;
						int br2iss4 = 0;

						for (int l = 0; l < 5; l++) {
							if (matrica[l][l + 4] == 2 && matrica[l + 1][l + 5] == 2) {
								br2izg4++;
								if (br2izg4 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2izg4 = 0;
							}

							if (matrica[l + 4][10 - l - 1] == 2 && matrica[l + 5][10 - l - 1 - 1] == 2) {
								br2iss4++;
								if (br2iss4 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2iss4 = 0;
							}
						}

						int br2izg5 = 0;
						int br2iss5 = 0;

						for (int l = 0; l < 4; l++) {
							if (matrica[l][l + 5] == 2 && matrica[l + 1][l + 6] == 2) {
								br2izg5++;
								if (br2izg5 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2izg5 = 0;
							}

							if (matrica[l + 5][10 - l - 1] == 2 && matrica[l + 6][10 - l - 1 - 1] == 2) {
								br2iss5++;
								if (br2iss5 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2iss5 = 0;
							}
						}

						int br2isg1 = 0;
						int br2izs1 = 0;
						for (int l = 0; l < 8; l++) {
							if (matrica[l + 1][l] == 2 && matrica[l + 2][l + 1] == 2) {
								br2isg1++;
								if (br2isg1 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2isg1 = 0;
							}

							if (matrica[l][10 - l - 1 - 1] == 2 && matrica[l + 1][10 - l - 3] == 2) {
								br2izs1++;
								if (br2izs1 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2izs1 = 0;
							}
						}

						int br2isg2 = 0;
						int br2izs2 = 0;
						for (int l = 0; l < 7; l++) {
							if (matrica[l + 2][l] == 2 && matrica[l + 3][l + 1] == 2) {
								br2isg2++;
								if (br2isg2 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2isg2 = 0;
							}

							if (matrica[l][10 - l - 3] == 2 && matrica[l + 1][10 - l - 4] == 2) {
								br2izs2++;
								if (br2izs2 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2izs2 = 0;
							}
						}

						int br2isg3 = 0;
						int br2izs3 = 0;
						for (int l = 0; l < 6; l++) {
							if (matrica[l + 3][l] == 2 && matrica[l + 4][l + 1] == 2) {
								br2isg3++;
								if (br2isg3 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2isg3 = 0;
							}

							if (matrica[l][10 - l - 4] == 2 && matrica[l + 1][10 - l - 5] == 2) {
								br2izs3++;
								if (br2izs3 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2izs3 = 0;
							}
						}

						int br2isg4 = 0;
						int br2izs4 = 0;
						for (int l = 0; l < 5; l++) {
							if (matrica[l + 4][l] == 2 && matrica[l + 5][l + 1] == 2) {
								br2isg4++;
								if (br2isg4 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2isg4 = 0;
							}

							if (matrica[l][10 - l - 5] == 2 && matrica[l + 1][10 - l - 6] == 2) {
								br2izs4++;
								if (br2izs4 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2izs4 = 0;
							}
						}

						int br2isg5 = 0;
						int br2izs5 = 0;
						for (int l = 0; l < 4; l++) {
							if (matrica[l + 5][l] == 2 && matrica[l + 6][l + 1] == 2) {
								br2isg5++;
								if (br2isg5 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2isg5 = 0;
							}

							if (matrica[l][10 - l - 6] == 2 && matrica[l + 1][10 - l - 7] == 2) {
								br2izs5++;
								if (br2izs5 == 4) {
									izlazniTokKaServeru.println("protivnik je pobedio");
									kraj = true;
									JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
											JOptionPane.ERROR_MESSAGE);
									socketZaKomunikaciju.close();
									return;
								}
							} else {
								br2izs5 = 0;
							}
						}

						int broj0 = 0;
						for (int k = 0; k < 10; k++) {
							for (int k2 = 0; k2 < 10; k2++) {
								if (matrica[k][k2] == 0)
									broj0++;
							}
						}

						if (broj0 == 0) {
							izlazniTokKaServeru.println("nema dalje");
							kraj = true;
							JOptionPane.showMessageDialog(frame, "Nema vise poteza! Zapocni novu igru!",
									"Nema vise poteza! Zapocni novu igru!", JOptionPane.ERROR_MESSAGE);
							socketZaKomunikaciju.close();
							return;
						}

						GUI.naPotezu = true;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/icon.png"));
		setTitle("Pet na red");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnlLevi(), BorderLayout.EAST);
		contentPane.add(getPnlPolja(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.SOUTH);

		components = pnlPolja.getComponents();
	}

	private JPanel getPnlLevi() {
		if (pnlLevi == null) {
			pnlLevi = new JPanel();
			pnlLevi.setLayout(new MigLayout("", "[100px]", "[14px][][][][]"));
			pnlLevi.add(getBtnOdustajem(), "cell 0 0,growx");
		}
		return pnlLevi;
	}

	private JPanel getPnlPolja() {
		if (pnlPolja == null) {
			pnlPolja = new JPanel();
			pnlPolja.setOpaque(false);
			pnlPolja.setLayout(new MigLayout("", "[][][][][][][][][][]", "[][][][][][][][][][]"));
			pnlPolja.add(getBtnFsadf(), "cell 0 0");
			pnlPolja.add(getButton_1(), "cell 1 0");
			pnlPolja.add(getButton_2(), "cell 2 0");
			pnlPolja.add(getBtnNewButton(), "cell 3 0");
			pnlPolja.add(getButton_3(), "cell 4 0");
			pnlPolja.add(getButton_4(), "cell 5 0");
			pnlPolja.add(getButton_5(), "cell 6 0");
			pnlPolja.add(getButton_6(), "cell 7 0");
			pnlPolja.add(getButton_7(), "cell 8 0");
			pnlPolja.add(getButton_8(), "cell 9 0");
			pnlPolja.add(getButton_9(), "cell 0 1");
			pnlPolja.add(getButton_10(), "cell 1 1");
			pnlPolja.add(getButton_11(), "cell 2 1");
			pnlPolja.add(getButton_12(), "cell 3 1");
			pnlPolja.add(getButton_13(), "cell 4 1");
			pnlPolja.add(getButton_14(), "cell 5 1");
			pnlPolja.add(getButton_15(), "cell 6 1");
			pnlPolja.add(getButton_16(), "cell 7 1");
			pnlPolja.add(getButton_17(), "cell 8 1");
			pnlPolja.add(getButton_18(), "cell 9 1");
			pnlPolja.add(getButton_19(), "cell 0 2");
			pnlPolja.add(getButton_20(), "cell 1 2");
			pnlPolja.add(getButton_21(), "cell 2 2");
			pnlPolja.add(getButton_22(), "cell 3 2");
			pnlPolja.add(getButton_23(), "cell 4 2");
			pnlPolja.add(getButton_24(), "cell 5 2");
			pnlPolja.add(getButton_25(), "cell 6 2");
			pnlPolja.add(getButton_26(), "cell 7 2");
			pnlPolja.add(getButton_27(), "cell 8 2");
			pnlPolja.add(getButton_28(), "cell 9 2");
			pnlPolja.add(getButton_30(), "cell 0 3");
			pnlPolja.add(getButton(), "cell 1 3");
			pnlPolja.add(getButton_29(), "cell 2 3");
			pnlPolja.add(getBtnNewButton_1(), "cell 3 3");
			pnlPolja.add(getButton_31(), "cell 4 3");
			pnlPolja.add(getButton_32(), "cell 5 3");
			pnlPolja.add(getButton_33(), "cell 6 3");
			pnlPolja.add(getButton_34(), "cell 7 3");
			pnlPolja.add(getButton_35(), "cell 8 3");
			pnlPolja.add(getButton_36(), "cell 9 3");
			pnlPolja.add(getButton_37(), "cell 0 4");
			pnlPolja.add(getButton_38(), "cell 1 4");
			pnlPolja.add(getButton_39(), "cell 2 4");
			pnlPolja.add(getButton_40(), "cell 3 4");
			pnlPolja.add(getButton_41(), "cell 4 4");
			pnlPolja.add(getButton_42(), "cell 5 4");
			pnlPolja.add(getButton_43(), "cell 6 4");
			pnlPolja.add(getButton_44(), "cell 7 4");
			pnlPolja.add(getButton_45(), "cell 8 4");
			pnlPolja.add(getButton_46(), "cell 9 4");
			pnlPolja.add(getButton_47(), "cell 0 5");
			pnlPolja.add(getButton_48(), "cell 1 5");
			pnlPolja.add(getButton_49(), "cell 2 5");
			pnlPolja.add(getButton_50(), "cell 3 5");
			pnlPolja.add(getButton_51(), "cell 4 5");
			pnlPolja.add(getButton_52(), "cell 5 5");
			pnlPolja.add(getButton_53(), "cell 6 5");
			pnlPolja.add(getButton_54(), "cell 7 5");
			pnlPolja.add(getButton_55(), "cell 8 5");
			pnlPolja.add(getButton_56(), "cell 9 5");
			pnlPolja.add(getButton_57(), "cell 0 6");
			pnlPolja.add(getButton_58(), "cell 1 6");
			pnlPolja.add(getButton_59(), "cell 2 6");
			pnlPolja.add(getBtnNewButton_2(), "cell 3 6");
			pnlPolja.add(getButton_60(), "cell 4 6");
			pnlPolja.add(getButton_61(), "cell 5 6");
			pnlPolja.add(getButton_62(), "cell 6 6");
			pnlPolja.add(getButton_63(), "cell 7 6");
			pnlPolja.add(getButton_64(), "cell 8 6");
			pnlPolja.add(getButton_65(), "cell 9 6");
			pnlPolja.add(getButton_66(), "cell 0 7");
			pnlPolja.add(getButton_67(), "cell 1 7");
			pnlPolja.add(getButton_68(), "cell 2 7");
			pnlPolja.add(getButton_69(), "cell 3 7");
			pnlPolja.add(getButton_70(), "cell 4 7");
			pnlPolja.add(getButton_71(), "cell 5 7");
			pnlPolja.add(getButton_72(), "cell 6 7");
			pnlPolja.add(getButton_73(), "cell 7 7");
			pnlPolja.add(getButton_74(), "cell 8 7");
			pnlPolja.add(getButton_75(), "cell 9 7");
			pnlPolja.add(getButton_76(), "cell 0 8");
			pnlPolja.add(getButton_77(), "cell 1 8");
			pnlPolja.add(getButton_78(), "cell 2 8");
			pnlPolja.add(getButton_79(), "cell 3 8");
			pnlPolja.add(getButton_80(), "cell 4 8");
			pnlPolja.add(getButton_81(), "cell 5 8");
			pnlPolja.add(getButton_82(), "cell 6 8");
			pnlPolja.add(getButton_83(), "cell 7 8");
			pnlPolja.add(getButton_84(), "cell 8 8");
			pnlPolja.add(getButton_85(), "cell 9 8");
			pnlPolja.add(getButton_86(), "cell 0 9");
			pnlPolja.add(getButton_87(), "cell 1 9");
			pnlPolja.add(getButton_88(), "cell 2 9");
			pnlPolja.add(getButton_89(), "cell 3 9");
			pnlPolja.add(getButton_90(), "cell 4 9");
			pnlPolja.add(getButton_91(), "cell 5 9");
			pnlPolja.add(getButton_92(), "cell 6 9");
			pnlPolja.add(getButton_93(), "cell 7 9");
			pnlPolja.add(getButton_94(), "cell 8 9");
			pnlPolja.add(getButton_95(), "cell 9 9");
		}
		return pnlPolja;
	}

	private JButton getBtnFsadf() {
		if (btnFsadf == null) {
			btnFsadf = new JButton("");

			btnFsadf.setBackground(Color.WHITE);
			btnFsadf.setName("00");
			btnFsadf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[0][0] == 0) {
						izlazniTokKaServeru.println(btnFsadf.getName());
						System.out.println("Vrednost iz matrince 00: " + matrica[0][0]);
						System.out.println("odigrao");
						btnFsadf.setBackground(new Color(230, 62, 98));
						btnFsadf.setVisible(true);
						btnFsadf.setContentAreaFilled(true);
						btnFsadf.setOpaque(true);
						matrica[0][0] = 1;
						System.out.println("Vrednost iz matrice 00 posle poteza:" + matrica[0][0]);
						GUI.naPotezu = false;
					}

				}
			});

			btnFsadf.setMaximumSize(new Dimension(15, 15));
			btnFsadf.setMinimumSize(new Dimension(15, 15));
			btnFsadf.setPreferredSize(new Dimension(15, 15));
			btnFsadf.setSize(new Dimension(15, 15));
		}
		return btnFsadf;
	}

	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("");
			button_1.setName("01");
			// button_1.setOpaque(false);
			button_1.setBackground(Color.WHITE);
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[0][1] == 0) {
						izlazniTokKaServeru.println(button_1.getName());
						System.out.println("odigrao");
						button_1.setBackground(new Color(230, 62, 98));
						button_1.setVisible(true);
						button_1.setContentAreaFilled(true);
						button_1.setOpaque(true);
						matrica[0][1] = 1;
						GUI.naPotezu = false;
					}
				}
			});

			button_1.setMaximumSize(new Dimension(15, 15));
			button_1.setMinimumSize(new Dimension(15, 15));
			button_1.setPreferredSize(new Dimension(15, 15));
			button_1.setSize(new Dimension(15, 15));
		}
		return button_1;
	}

	private JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("");
			button_2.setName("02");
			// button_2.setOpaque(false);
			button_2.setBackground(Color.WHITE);
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[0][2] == 0) {
						izlazniTokKaServeru.println(button_2.getName());
						System.out.println("odigrao 0 2");
						button_2.setBackground(new Color(230, 62, 98));
						button_2.setVisible(true);
						button_2.setContentAreaFilled(true);
						button_2.setOpaque(true);
						matrica[0][2] = 1;
						GUI.naPotezu = false;
					}
				}
			});

			button_2.setMaximumSize(new Dimension(15, 15));
			button_2.setMinimumSize(new Dimension(15, 15));
			button_2.setPreferredSize(new Dimension(15, 15));
			button_2.setSize(new Dimension(15, 15));
		}
		return button_2;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setName("03");
			// btnNewButton.setOpaque(false);
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (GUI.naPotezu == true && matrica[0][3] == 0) {
						izlazniTokKaServeru.println(btnNewButton.getName());
						System.out.println("odigrao 0 3");
						btnNewButton.setBackground(new Color(230, 62, 98));
						btnNewButton.setVisible(true);
						btnNewButton.setContentAreaFilled(true);
						btnNewButton.setOpaque(true);
						matrica[0][3] = 1;
						GUI.naPotezu = false;
					}
				}
			});

			btnNewButton.setName("03");
			btnNewButton.setMaximumSize(new Dimension(15, 15));
			btnNewButton.setMinimumSize(new Dimension(15, 15));
			btnNewButton.setPreferredSize(new Dimension(15, 15));
			btnNewButton.setSize(new Dimension(15, 15));
		}
		return btnNewButton;
	}

	private JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton("");
			button_3.setName("04");
			// button_3.setOpaque(false);
			button_3.setBackground(Color.WHITE);
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (GUI.naPotezu == true && matrica[0][4] == 0) {
						izlazniTokKaServeru.println(button_3.getName());
						System.out.println("odigrao 0 3");
						button_3.setBackground(new Color(230, 62, 98));
						button_3.setVisible(true);
						button_3.setContentAreaFilled(true);
						button_3.setOpaque(true);
						matrica[0][4] = 1;
						GUI.naPotezu = false;
					}
				}
			});

			button_3.setMaximumSize(new Dimension(15, 15));
			button_3.setMinimumSize(new Dimension(15, 15));
			button_3.setPreferredSize(new Dimension(15, 15));
			button_3.setSize(new Dimension(15, 15));
		}
		return button_3;
	}

	private JButton getButton_4() {
		if (button_4 == null) {
			button_4 = new JButton("");
			button_4.setName("05");
			// button_4.setOpaque(false);

			button_4.setBackground(Color.WHITE);
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[0][5] == 0) {
						izlazniTokKaServeru.println(button_4.getName());
						System.out.println("odigrao 0 5");
						button_4.setBackground(new Color(230, 62, 98));
						button_4.setVisible(true);
						button_4.setContentAreaFilled(true);
						button_4.setOpaque(true);
						matrica[0][5] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_4.setMaximumSize(new Dimension(15, 15));
			button_4.setMinimumSize(new Dimension(15, 15));
			button_4.setPreferredSize(new Dimension(15, 15));
			button_4.setSize(new Dimension(15, 15));
		}
		return button_4;
	}

	private JButton getButton_5() {
		if (button_5 == null) {
			button_5 = new JButton("");
			button_5.setName("06");

			button_5.setBackground(Color.WHITE);
			button_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[0][6] == 0) {
						izlazniTokKaServeru.println(button_5.getName());
						System.out.println("odigrao 0 6");
						button_5.setBackground(new Color(230, 62, 98));
						button_5.setVisible(true);
						button_5.setContentAreaFilled(true);
						button_5.setOpaque(true);
						matrica[0][6] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_5.setMaximumSize(new Dimension(15, 15));
			button_5.setMinimumSize(new Dimension(15, 15));
			button_5.setPreferredSize(new Dimension(15, 15));
			button_5.setSize(new Dimension(15, 15));
		}
		return button_5;
	}

	private JButton getButton_6() {
		if (button_6 == null) {
			button_6 = new JButton("");
			button_6.setName("07");
			button_6.setBackground(Color.WHITE);
			button_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[0][7] == 0) {
						izlazniTokKaServeru.println(button_6.getName());
						System.out.println("odigrao 0 7");
						button_6.setBackground(new Color(230, 62, 98));
						button_6.setVisible(true);
						button_6.setContentAreaFilled(true);
						button_6.setOpaque(true);
						matrica[0][7] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_6.setMaximumSize(new Dimension(15, 15));
			button_6.setMinimumSize(new Dimension(15, 15));
			button_6.setPreferredSize(new Dimension(15, 15));
			button_6.setSize(new Dimension(15, 15));
		}
		return button_6;
	}

	private JButton getButton_7() {
		if (button_7 == null) {
			button_7 = new JButton("");
			button_7.setName("08");
			button_7.setBackground(Color.WHITE);
			button_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[0][8] == 0) {
						izlazniTokKaServeru.println(button_7.getName());
						System.out.println("odigrao 0 8");
						button_7.setBackground(new Color(230, 62, 98));
						button_7.setVisible(true);
						button_7.setContentAreaFilled(true);
						button_7.setOpaque(true);
						matrica[0][8] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_7.setMaximumSize(new Dimension(15, 15));
			button_7.setMinimumSize(new Dimension(15, 15));
			button_7.setPreferredSize(new Dimension(15, 15));
			button_7.setSize(new Dimension(15, 15));
		}
		return button_7;
	}

	private JButton getButton_8() {
		if (button_8 == null) {
			button_8 = new JButton("");
			button_8.setName("09");
			button_8.setBackground(Color.WHITE);
			button_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[0][9] == 0) {
						izlazniTokKaServeru.println(button_8.getName());
						System.out.println("odigrao 0 9");
						button_8.setBackground(new Color(230, 62, 98));
						button_8.setVisible(true);
						button_8.setContentAreaFilled(true);
						button_8.setOpaque(true);
						matrica[0][9] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_8.setMaximumSize(new Dimension(15, 15));
			button_8.setMinimumSize(new Dimension(15, 15));
		}
		return button_8;
	}

	private JButton getButton_9() {
		if (button_9 == null) {
			button_9 = new JButton("");
			button_9.setName("10");
			button_9.setBackground(Color.WHITE);
			button_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[1][0] == 0) {
						izlazniTokKaServeru.println(button_9.getName());
						System.out.println("odigrao 1 0");
						button_9.setBackground(new Color(230, 62, 98));
						button_9.setVisible(true);
						button_9.setContentAreaFilled(true);
						button_9.setOpaque(true);
						matrica[1][0] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_9.setMaximumSize(new Dimension(15, 15));
			button_9.setMinimumSize(new Dimension(15, 15));
			button_9.setPreferredSize(new Dimension(15, 15));
			button_9.setSize(new Dimension(15, 15));
		}
		return button_9;
	}

	private JButton getButton_10() {
		if (button_10 == null) {
			button_10 = new JButton("");
			button_10.setName("11");
			button_10.setBackground(Color.WHITE);
			button_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[1][1] == 0) {
						izlazniTokKaServeru.println(button_10.getName());
						button_10.setBackground(new Color(230, 62, 98));
						button_10.setVisible(true);
						button_10.setContentAreaFilled(true);
						button_10.setOpaque(true);
						matrica[1][1] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_10.setMaximumSize(new Dimension(15, 15));
			button_10.setMinimumSize(new Dimension(15, 15));
			button_10.setPreferredSize(new Dimension(15, 15));
			button_10.setSize(new Dimension(15, 15));
		}
		return button_10;
	}

	private JButton getButton_11() {
		if (button_11 == null) {
			button_11 = new JButton("");
			button_11.setName("12");
			button_11.setBackground(Color.WHITE);
			button_11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[1][2] == 0) {
						izlazniTokKaServeru.println(button_11.getName());
						button_11.setBackground(new Color(230, 62, 98));
						button_11.setVisible(true);
						button_11.setContentAreaFilled(true);
						button_11.setOpaque(true);
						matrica[1][2] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_11.setMaximumSize(new Dimension(15, 15));
			button_11.setMinimumSize(new Dimension(15, 15));
			button_11.setPreferredSize(new Dimension(15, 15));
			button_11.setSize(new Dimension(15, 15));
		}
		return button_11;
	}

	private JButton getButton_12() {
		if (button_12 == null) {
			button_12 = new JButton("");
			button_12.setName("13");
			button_12.setBackground(Color.WHITE);
			button_12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[1][3] == 0) {
						izlazniTokKaServeru.println(button_12.getName());
						button_12.setBackground(new Color(230, 62, 98));
						button_12.setVisible(true);
						button_12.setContentAreaFilled(true);
						button_12.setOpaque(true);
						matrica[1][3] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_12.setMaximumSize(new Dimension(15, 15));
			button_12.setMinimumSize(new Dimension(15, 15));
			button_12.setPreferredSize(new Dimension(15, 15));
			button_12.setSize(new Dimension(15, 15));
		}
		return button_12;
	}

	private JButton getButton_13() {
		if (button_13 == null) {
			button_13 = new JButton("");
			button_13.setName("14");
			button_13.setBackground(Color.WHITE);
			button_13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[1][4] == 0) {
						izlazniTokKaServeru.println(button_13.getName());
						button_13.setBackground(new Color(230, 62, 98));
						button_13.setVisible(true);
						button_13.setContentAreaFilled(true);
						button_13.setOpaque(true);
						matrica[1][4] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_13.setMaximumSize(new Dimension(15, 15));
			button_13.setMinimumSize(new Dimension(15, 15));
			button_13.setPreferredSize(new Dimension(15, 15));
			button_13.setSize(new Dimension(15, 15));
		}
		return button_13;
	}

	private JButton getButton_14() {
		if (button_14 == null) {
			button_14 = new JButton("");
			button_14.setName("15");
			button_14.setBackground(Color.WHITE);
			button_14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[1][5] == 0) {
						izlazniTokKaServeru.println(button_14.getName());
						button_14.setBackground(new Color(230, 62, 98));
						button_14.setVisible(true);
						button_14.setContentAreaFilled(true);
						button_14.setOpaque(true);
						matrica[1][5] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_14.setMaximumSize(new Dimension(15, 15));
			button_14.setMinimumSize(new Dimension(15, 15));
			button_14.setPreferredSize(new Dimension(15, 15));
			button_14.setSize(new Dimension(15, 15));
		}
		return button_14;
	}

	private JButton getButton_15() {
		if (button_15 == null) {
			button_15 = new JButton("");
			button_15.setName("16");
			button_15.setBackground(Color.WHITE);
			button_15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[1][6] == 0) {
						izlazniTokKaServeru.println(button_15.getName());
						button_15.setBackground(new Color(230, 62, 98));
						button_15.setVisible(true);
						button_15.setContentAreaFilled(true);
						button_15.setOpaque(true);
						matrica[1][6] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_15.setMaximumSize(new Dimension(15, 15));
			button_15.setMinimumSize(new Dimension(15, 15));
			button_15.setPreferredSize(new Dimension(15, 15));
			button_15.setSize(new Dimension(15, 15));
		}
		return button_15;
	}

	private JButton getButton_16() {
		if (button_16 == null) {
			button_16 = new JButton("");
			button_16.setName("17");
			button_16.setBackground(Color.WHITE);
			button_16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[1][7] == 0) {
						izlazniTokKaServeru.println(button_16.getName());
						button_16.setBackground(new Color(230, 62, 98));
						button_16.setVisible(true);
						button_16.setContentAreaFilled(true);
						button_16.setOpaque(true);
						matrica[1][7] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_16.setMinimumSize(new Dimension(15, 15));
			button_16.setMaximumSize(new Dimension(15, 15));
		}
		return button_16;
	}

	private JButton getButton_17() {
		if (button_17 == null) {
			button_17 = new JButton("");
			button_17.setName("18");
			button_17.setBackground(Color.WHITE);
			button_17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[1][8] == 0) {
						izlazniTokKaServeru.println(button_17.getName());
						button_17.setBackground(new Color(230, 62, 98));
						button_17.setVisible(true);
						button_17.setContentAreaFilled(true);
						button_17.setOpaque(true);
						matrica[1][8] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_17.setMinimumSize(new Dimension(15, 15));
			button_17.setMaximumSize(new Dimension(15, 15));
		}
		return button_17;
	}

	private JButton getButton_18() {
		if (button_18 == null) {
			button_18 = new JButton("");
			button_18.setName("19");
			button_18.setBackground(Color.WHITE);
			button_18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[1][9] == 0) {
						izlazniTokKaServeru.println(button_18.getName());
						button_18.setBackground(new Color(230, 62, 98));
						button_18.setVisible(true);
						button_18.setContentAreaFilled(true);
						button_18.setOpaque(true);
						matrica[1][9] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_18.setMaximumSize(new Dimension(15, 15));
			button_18.setMinimumSize(new Dimension(15, 15));
		}
		return button_18;
	}

	private JButton getButton_19() {
		if (button_19 == null) {
			button_19 = new JButton("");
			button_19.setName("20");
			button_19.setBackground(Color.WHITE);
			button_19.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[2][0] == 0) {
						izlazniTokKaServeru.println(button_19.getName());
						button_19.setBackground(new Color(230, 62, 98));
						button_19.setVisible(true);
						button_19.setContentAreaFilled(true);
						button_19.setOpaque(true);
						matrica[2][0] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_19.setMinimumSize(new Dimension(15, 15));
			button_19.setMaximumSize(new Dimension(15, 15));
		}
		return button_19;
	}

	private JButton getButton_20() {
		if (button_20 == null) {
			button_20 = new JButton("");
			button_20.setName("21");
			button_20.setBackground(Color.WHITE);
			button_20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[2][1] == 0) {
						izlazniTokKaServeru.println(button_20.getName());
						button_20.setBackground(new Color(230, 62, 98));
						button_20.setVisible(true);
						button_20.setContentAreaFilled(true);
						button_20.setOpaque(true);
						matrica[2][1] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_20.setMinimumSize(new Dimension(15, 15));
			button_20.setMaximumSize(new Dimension(15, 15));
		}
		return button_20;
	}

	private JButton getButton_21() {
		if (button_21 == null) {
			button_21 = new JButton("");
			button_21.setName("22");
			button_21.setBackground(Color.WHITE);
			button_21.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[2][2] == 0) {
						izlazniTokKaServeru.println(button_21.getName());
						button_21.setBackground(new Color(230, 62, 98));
						button_21.setVisible(true);
						button_21.setContentAreaFilled(true);
						button_21.setOpaque(true);
						matrica[2][2] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_21.setMinimumSize(new Dimension(15, 15));
			button_21.setMaximumSize(new Dimension(15, 15));
		}
		return button_21;
	}

	private JButton getButton_22() {
		if (button_22 == null) {
			button_22 = new JButton("");
			button_22.setName("23");
			button_22.setBackground(Color.WHITE);
			button_22.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[2][3] == 0) {
						izlazniTokKaServeru.println(button_22.getName());
						button_22.setBackground(new Color(230, 62, 98));
						button_22.setVisible(true);
						button_22.setContentAreaFilled(true);
						button_22.setOpaque(true);
						matrica[2][3] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_22.setMinimumSize(new Dimension(15, 15));
			button_22.setMaximumSize(new Dimension(15, 15));
		}
		return button_22;
	}

	private JButton getButton_23() {
		if (button_23 == null) {
			button_23 = new JButton("");
			button_23.setName("24");
			button_23.setBackground(Color.WHITE);
			button_23.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[2][4] == 0) {
						izlazniTokKaServeru.println(button_23.getName());
						button_23.setBackground(new Color(230, 62, 98));
						button_23.setVisible(true);
						button_23.setContentAreaFilled(true);
						button_23.setOpaque(true);
						matrica[2][4] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_23.setMinimumSize(new Dimension(15, 15));
			button_23.setMaximumSize(new Dimension(15, 15));
		}
		return button_23;
	}

	private JButton getButton_24() {
		if (button_24 == null) {
			button_24 = new JButton("");
			button_24.setName("25");
			button_24.setBackground(Color.WHITE);
			button_24.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[2][5] == 0) {
						izlazniTokKaServeru.println(button_24.getName());
						button_24.setBackground(new Color(230, 62, 98));
						button_24.setVisible(true);
						button_24.setContentAreaFilled(true);
						button_24.setOpaque(true);
						matrica[2][5] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_24.setMinimumSize(new Dimension(15, 15));
			button_24.setMaximumSize(new Dimension(15, 15));
		}
		return button_24;
	}

	private JButton getButton_25() {
		if (button_25 == null) {
			button_25 = new JButton("");
			button_25.setName("26");
			button_25.setBackground(Color.WHITE);
			button_25.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[2][6] == 0) {
						izlazniTokKaServeru.println(button_25.getName());
						button_25.setBackground(new Color(230, 62, 98));
						button_25.setVisible(true);
						button_25.setContentAreaFilled(true);
						button_25.setOpaque(true);
						matrica[2][6] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_25.setMinimumSize(new Dimension(15, 15));
			button_25.setMaximumSize(new Dimension(15, 15));
		}
		return button_25;
	}

	private JButton getButton_26() {
		if (button_26 == null) {
			button_26 = new JButton("");
			button_26.setName("27");
			button_26.setBackground(Color.WHITE);
			button_26.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[2][7] == 0) {
						izlazniTokKaServeru.println(button_26.getName());
						button_26.setBackground(new Color(230, 62, 98));
						button_26.setVisible(true);
						button_26.setContentAreaFilled(true);
						button_26.setOpaque(true);
						matrica[2][7] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_26.setMinimumSize(new Dimension(15, 15));
			button_26.setMaximumSize(new Dimension(15, 15));
		}
		return button_26;
	}

	private JButton getButton_27() {
		if (button_27 == null) {
			button_27 = new JButton("");
			button_27.setName("28");
			button_27.setBackground(Color.WHITE);
			button_27.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[2][8] == 0) {
						izlazniTokKaServeru.println(button_27.getName());
						button_27.setBackground(new Color(230, 62, 98));
						button_27.setVisible(true);
						button_27.setContentAreaFilled(true);
						button_27.setOpaque(true);
						matrica[2][8] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_27.setMinimumSize(new Dimension(15, 15));
			button_27.setMaximumSize(new Dimension(15, 15));
		}
		return button_27;
	}

	private JButton getButton_28() {
		if (button_28 == null) {
			button_28 = new JButton("");
			button_28.setName("29");
			button_28.setBackground(Color.WHITE);
			button_28.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[2][9] == 0) {
						izlazniTokKaServeru.println(button_28.getName());
						button_28.setBackground(new Color(230, 62, 98));
						button_28.setVisible(true);
						button_28.setContentAreaFilled(true);
						button_28.setOpaque(true);
						matrica[2][9] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_28.setMinimumSize(new Dimension(15, 15));
			button_28.setMaximumSize(new Dimension(15, 15));
		}
		return button_28;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new MigLayout("", "[grow]", "[grow][grow]"));
			panel.add(getKonzolaIspis(), "cell 0 0,grow");
			panel.add(getKonzolaUnos(), "cell 0 1,grow");
		}
		return panel;
	}

	private JTextArea getKonzolaIspis() {
		if (konzolaIspis == null) {
			konzolaIspis = new JTextArea();
		}
		return konzolaIspis;
	}

	private JTextArea getKonzolaUnos() {
		if (konzolaUnos == null) {
			konzolaUnos = new JTextArea();
			konzolaUnos.setText("");
		}
		return konzolaUnos;
	}

	public static void konektujSe() {
		try {
			int port = 6776;

			socketZaKomunikaciju = new Socket("localhost", port); //!!

			izlazniTokKaServeru = new PrintStream(socketZaKomunikaciju.getOutputStream());
			ulazniTokOdServera = new BufferedReader(new InputStreamReader(socketZaKomunikaciju.getInputStream()));

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private JButton getButton_30() {
		if (button_30 == null) {
			button_30 = new JButton("");
			button_30.setName("30");
			button_30.setBackground(Color.WHITE);
			button_30.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[3][0] == 0) {
						izlazniTokKaServeru.println(button_30.getName());
						button_30.setBackground(new Color(230, 62, 98));
						button_30.setVisible(true);
						button_30.setContentAreaFilled(true);
						button_30.setOpaque(true);
						matrica[3][0] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_30.setMinimumSize(new Dimension(15, 15));
			button_30.setMaximumSize(new Dimension(15, 15));
		}
		return button_30;
	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton("");
			button.setName("31");
			button.setBackground(Color.WHITE);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[3][1] == 0) {
						izlazniTokKaServeru.println(button.getName());
						button.setBackground(new Color(230, 62, 98));
						button.setVisible(true);
						button.setContentAreaFilled(true);
						button.setOpaque(true);
						matrica[3][1] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button.setMinimumSize(new Dimension(15, 15));
			button.setMaximumSize(new Dimension(15, 15));
		}
		return button;
	}

	private JButton getButton_29() {
		if (button_29 == null) {
			button_29 = new JButton("");
			button_29.setName("32");
			button_29.setBackground(Color.WHITE);
			button_29.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[3][2] == 0) {
						izlazniTokKaServeru.println(button_29.getName());
						button_29.setBackground(new Color(230, 62, 98));
						button_29.setVisible(true);
						button_29.setContentAreaFilled(true);
						button_29.setOpaque(true);
						matrica[3][2] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_29.setMinimumSize(new Dimension(15, 15));
			button_29.setMaximumSize(new Dimension(15, 15));
		}
		return button_29;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			btnNewButton_1.setName("33");
			btnNewButton_1.setBackground(Color.WHITE);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[3][3] == 0) {
						izlazniTokKaServeru.println(btnNewButton_1.getName());
						btnNewButton_1.setBackground(new Color(230, 62, 98));
						btnNewButton_1.setVisible(true);
						btnNewButton_1.setContentAreaFilled(true);
						btnNewButton_1.setOpaque(true);
						matrica[3][3] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			btnNewButton_1.setMinimumSize(new Dimension(15, 15));
			btnNewButton_1.setMaximumSize(new Dimension(15, 15));
		}
		return btnNewButton_1;
	}

	private JButton getButton_31() {
		if (button_31 == null) {
			button_31 = new JButton("");
			button_31.setName("34");
			button_31.setBackground(Color.WHITE);
			button_31.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[3][4] == 0) {
						izlazniTokKaServeru.println(button_31.getName());
						button_31.setBackground(new Color(230, 62, 98));
						button_31.setVisible(true);
						button_31.setContentAreaFilled(true);
						button_31.setOpaque(true);
						matrica[3][4] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_31.setMinimumSize(new Dimension(15, 15));
			button_31.setMaximumSize(new Dimension(15, 15));
		}
		return button_31;
	}

	private JButton getButton_32() {
		if (button_32 == null) {
			button_32 = new JButton("");
			button_32.setName("35");
			button_32.setBackground(Color.WHITE);
			button_32.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[3][5] == 0) {
						izlazniTokKaServeru.println(button_32.getName());
						button_32.setBackground(new Color(230, 62, 98));
						button_32.setVisible(true);
						button_32.setContentAreaFilled(true);
						button_32.setOpaque(true);
						matrica[3][5] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_32.setMinimumSize(new Dimension(15, 15));
			button_32.setMaximumSize(new Dimension(15, 15));
		}
		return button_32;
	}

	private JButton getButton_33() {
		if (button_33 == null) {
			button_33 = new JButton("");
			button_33.setName("36");
			button_33.setBackground(Color.WHITE);
			button_33.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[3][6] == 0) {
						izlazniTokKaServeru.println(button_33.getName());
						button_33.setBackground(new Color(230, 62, 98));
						button_33.setVisible(true);
						button_33.setContentAreaFilled(true);
						button_33.setOpaque(true);
						matrica[3][6] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_33.setMinimumSize(new Dimension(15, 15));
			button_33.setMaximumSize(new Dimension(15, 15));
		}
		return button_33;
	}

	private JButton getButton_34() {
		if (button_34 == null) {
			button_34 = new JButton("");
			button_34.setName("37");
			button_34.setBackground(Color.WHITE);
			button_34.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[3][7] == 0) {
						izlazniTokKaServeru.println(button_34.getName());
						button_34.setBackground(new Color(230, 62, 98));
						button_34.setVisible(true);
						button_34.setContentAreaFilled(true);
						button_34.setOpaque(true);
						matrica[3][7] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_34.setMinimumSize(new Dimension(15, 15));
			button_34.setMaximumSize(new Dimension(15, 15));
		}
		return button_34;
	}

	private JButton getButton_35() {
		if (button_35 == null) {
			button_35 = new JButton("");
			button_35.setName("38");
			button_35.setBackground(Color.WHITE);
			button_35.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[3][8] == 0) {
						izlazniTokKaServeru.println(button_35.getName());
						button_35.setBackground(new Color(230, 62, 98));
						button_35.setVisible(true);
						button_35.setContentAreaFilled(true);
						button_35.setOpaque(true);
						matrica[3][8] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_35.setMinimumSize(new Dimension(15, 15));
			button_35.setMaximumSize(new Dimension(15, 15));
		}
		return button_35;
	}

	private JButton getButton_36() {
		if (button_36 == null) {
			button_36 = new JButton("");
			button_36.setName("39");
			button_36.setBackground(Color.WHITE);
			button_36.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[3][9] == 0) {
						izlazniTokKaServeru.println(button_36.getName());
						button_36.setBackground(new Color(230, 62, 98));
						button_36.setVisible(true);
						button_36.setContentAreaFilled(true);
						button_36.setOpaque(true);
						matrica[3][9] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_36.setMinimumSize(new Dimension(15, 15));
			button_36.setMaximumSize(new Dimension(15, 15));
		}
		return button_36;
	}

	private JButton getButton_37() {
		if (button_37 == null) {
			button_37 = new JButton("");
			button_37.setName("40");
			button_37.setBackground(Color.WHITE);
			button_37.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[4][0] == 0) {
						izlazniTokKaServeru.println(button_37.getName());
						button_37.setBackground(new Color(230, 62, 98));
						button_37.setVisible(true);
						button_37.setContentAreaFilled(true);
						button_37.setOpaque(true);
						matrica[4][0] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_37.setMaximumSize(new Dimension(15, 15));
			button_37.setMinimumSize(new Dimension(15, 15));
		}
		return button_37;
	}

	private JButton getButton_38() {
		if (button_38 == null) {
			button_38 = new JButton("");
			button_38.setName("41");
			button_38.setBackground(Color.WHITE);
			button_38.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[4][1] == 0) {
						izlazniTokKaServeru.println(button_38.getName());
						button_38.setBackground(new Color(230, 62, 98));
						button_38.setVisible(true);
						button_38.setContentAreaFilled(true);
						button_38.setOpaque(true);
						matrica[4][1] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_38.setMaximumSize(new Dimension(15, 15));
			button_38.setMinimumSize(new Dimension(15, 15));
		}
		return button_38;
	}

	private JButton getButton_39() {
		if (button_39 == null) {
			button_39 = new JButton("");
			button_39.setName("42");
			button_39.setBackground(Color.WHITE);
			button_39.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[4][2] == 0) {
						izlazniTokKaServeru.println(button_39.getName());
						button_39.setBackground(new Color(230, 62, 98));
						button_39.setVisible(true);
						button_39.setContentAreaFilled(true);
						button_39.setOpaque(true);
						matrica[4][2] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_39.setMaximumSize(new Dimension(15, 15));
			button_39.setMinimumSize(new Dimension(15, 15));
		}
		return button_39;
	}

	private JButton getButton_40() {
		if (button_40 == null) {
			button_40 = new JButton("");
			button_40.setName("43");
			button_40.setBackground(Color.WHITE);
			button_40.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[4][3] == 0) {
						izlazniTokKaServeru.println(button_40.getName());
						button_40.setBackground(new Color(230, 62, 98));
						button_40.setVisible(true);
						button_40.setContentAreaFilled(true);
						button_40.setOpaque(true);
						matrica[4][3] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_40.setMaximumSize(new Dimension(15, 15));
			button_40.setMinimumSize(new Dimension(15, 15));
		}
		return button_40;
	}

	private JButton getButton_41() {
		if (button_41 == null) {
			button_41 = new JButton("");
			button_41.setName("44");
			button_41.setBackground(Color.WHITE);
			button_41.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[4][4] == 0) {
						izlazniTokKaServeru.println(button_41.getName());
						button_41.setBackground(new Color(230, 62, 98));
						button_41.setVisible(true);
						button_41.setContentAreaFilled(true);
						button_41.setOpaque(true);
						matrica[4][4] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_41.setMaximumSize(new Dimension(15, 15));
			button_41.setMinimumSize(new Dimension(15, 15));
		}
		return button_41;
	}

	private JButton getButton_42() {
		if (button_42 == null) {
			button_42 = new JButton("");
			button_42.setName("45");
			button_42.setBackground(Color.WHITE);
			button_42.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[4][5] == 0) {
						izlazniTokKaServeru.println(button_42.getName());
						button_42.setBackground(new Color(230, 62, 98));
						button_42.setVisible(true);
						button_42.setContentAreaFilled(true);
						button_42.setOpaque(true);
						matrica[4][5] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_42.setMaximumSize(new Dimension(15, 15));
			button_42.setMinimumSize(new Dimension(15, 15));
		}
		return button_42;
	}

	private JButton getButton_43() {
		if (button_43 == null) {
			button_43 = new JButton("");
			button_43.setName("46");
			button_43.setBackground(Color.WHITE);
			button_43.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[4][6] == 0) {
						izlazniTokKaServeru.println(button_43.getName());
						button_43.setBackground(new Color(230, 62, 98));
						button_43.setVisible(true);
						button_43.setContentAreaFilled(true);
						button_43.setOpaque(true);
						matrica[4][6] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_43.setMaximumSize(new Dimension(15, 15));
			button_43.setMinimumSize(new Dimension(15, 15));
		}
		return button_43;
	}

	private JButton getButton_44() {
		if (button_44 == null) {
			button_44 = new JButton("");
			button_44.setName("47");
			button_44.setBackground(Color.WHITE);
			button_44.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[4][7] == 0) {
						izlazniTokKaServeru.println(button_44.getName());
						button_44.setBackground(new Color(230, 62, 98));
						button_44.setVisible(true);
						button_44.setContentAreaFilled(true);
						button_44.setOpaque(true);
						matrica[4][7] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_44.setMinimumSize(new Dimension(15, 15));
			button_44.setMaximumSize(new Dimension(15, 15));
		}
		return button_44;
	}

	private JButton getButton_45() {
		if (button_45 == null) {
			button_45 = new JButton("");
			button_45.setName("48");
			button_45.setBackground(Color.WHITE);
			button_45.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[4][8] == 0) {
						izlazniTokKaServeru.println(button_45.getName());
						button_45.setBackground(new Color(230, 62, 98));
						button_45.setVisible(true);
						button_45.setContentAreaFilled(true);
						button_45.setOpaque(true);
						matrica[4][8] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_45.setMinimumSize(new Dimension(15, 15));
			button_45.setMaximumSize(new Dimension(15, 15));
		}
		return button_45;
	}

	private JButton getButton_46() {
		if (button_46 == null) {
			button_46 = new JButton("");
			button_46.setName("49");
			button_46.setBackground(Color.WHITE);
			button_46.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[4][9] == 0) {
						izlazniTokKaServeru.println(button_46.getName());
						button_46.setBackground(new Color(230, 62, 98));
						button_46.setVisible(true);
						button_46.setContentAreaFilled(true);
						button_46.setOpaque(true);
						matrica[4][9] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_46.setMinimumSize(new Dimension(15, 15));
			button_46.setMaximumSize(new Dimension(15, 15));
		}
		return button_46;
	}

	private JButton getButton_47() {
		if (button_47 == null) {
			button_47 = new JButton("");
			button_47.setName("50");
			button_47.setBackground(Color.WHITE);
			button_47.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[5][0] == 0) {
						izlazniTokKaServeru.println(button_47.getName());
						button_47.setBackground(new Color(230, 62, 98));
						button_47.setVisible(true);
						button_47.setContentAreaFilled(true);
						button_47.setOpaque(true);
						matrica[5][0] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_47.setMaximumSize(new Dimension(15, 15));
			button_47.setMinimumSize(new Dimension(15, 15));
		}
		return button_47;
	}

	private JButton getButton_48() {
		if (button_48 == null) {
			button_48 = new JButton("");
			button_48.setName("51");
			button_48.setBackground(Color.WHITE);
			button_48.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[5][1] == 0) {
						izlazniTokKaServeru.println(button_48.getName());
						button_48.setBackground(new Color(230, 62, 98));
						button_48.setVisible(true);
						button_48.setContentAreaFilled(true);
						button_48.setOpaque(true);
						matrica[5][1] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_48.setMaximumSize(new Dimension(15, 15));
			button_48.setMinimumSize(new Dimension(15, 15));
		}
		return button_48;
	}

	private JButton getButton_49() {
		if (button_49 == null) {
			button_49 = new JButton("");
			button_49.setName("52");
			button_49.setBackground(Color.WHITE);
			button_49.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[5][2] == 0) {
						izlazniTokKaServeru.println(button_49.getName());
						button_49.setBackground(new Color(230, 62, 98));
						button_49.setVisible(true);
						button_49.setContentAreaFilled(true);
						button_49.setOpaque(true);
						matrica[5][2] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_49.setMaximumSize(new Dimension(15, 15));
			button_49.setMinimumSize(new Dimension(15, 15));
		}
		return button_49;
	}

	private JButton getButton_50() {
		if (button_50 == null) {
			button_50 = new JButton("");
			button_50.setName("53");
			button_50.setBackground(Color.WHITE);
			button_50.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[5][3] == 0) {
						izlazniTokKaServeru.println(button_50.getName());
						button_50.setBackground(new Color(230, 62, 98));
						button_50.setVisible(true);
						button_50.setContentAreaFilled(true);
						button_50.setOpaque(true);
						matrica[5][3] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_50.setMaximumSize(new Dimension(15, 15));
			button_50.setMinimumSize(new Dimension(15, 15));
		}
		return button_50;
	}

	private JButton getButton_51() {
		if (button_51 == null) {
			button_51 = new JButton("");
			button_51.setName("54");
			button_51.setBackground(Color.WHITE);
			button_51.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[5][4] == 0) {
						izlazniTokKaServeru.println(button_51.getName());
						button_51.setBackground(new Color(230, 62, 98));
						button_51.setVisible(true);
						button_51.setContentAreaFilled(true);
						button_51.setOpaque(true);
						matrica[5][4] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_51.setMaximumSize(new Dimension(15, 15));
			button_51.setMinimumSize(new Dimension(15, 15));
		}
		return button_51;
	}

	private JButton getButton_52() {
		if (button_52 == null) {
			button_52 = new JButton("");
			button_52.setName("55");
			button_52.setBackground(Color.WHITE);
			button_52.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[5][5] == 0) {
						izlazniTokKaServeru.println(button_52.getName());
						button_52.setBackground(new Color(230, 62, 98));
						button_52.setVisible(true);
						button_52.setContentAreaFilled(true);
						button_52.setOpaque(true);
						matrica[5][5] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_52.setMinimumSize(new Dimension(15, 15));
			button_52.setMaximumSize(new Dimension(15, 15));
		}
		return button_52;
	}

	private JButton getButton_53() {
		if (button_53 == null) {
			button_53 = new JButton("");
			button_53.setName("56");
			button_53.setBackground(Color.WHITE);
			button_53.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[5][6] == 0) {
						izlazniTokKaServeru.println(button_53.getName());
						button_53.setBackground(new Color(230, 62, 98));
						button_53.setVisible(true);
						button_53.setContentAreaFilled(true);
						button_53.setOpaque(true);
						matrica[5][6] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_53.setMinimumSize(new Dimension(15, 15));
			button_53.setMaximumSize(new Dimension(15, 15));
		}
		return button_53;
	}

	private JButton getButton_54() {
		if (button_54 == null) {
			button_54 = new JButton("");
			button_54.setName("57");
			button_54.setBackground(Color.WHITE);
			button_54.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[5][7] == 0) {
						izlazniTokKaServeru.println(button_54.getName());
						button_54.setBackground(new Color(230, 62, 98));
						button_54.setVisible(true);
						button_54.setContentAreaFilled(true);
						button_54.setOpaque(true);
						matrica[5][7] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_54.setMinimumSize(new Dimension(15, 15));
			button_54.setMaximumSize(new Dimension(15, 15));
		}
		return button_54;
	}

	private JButton getButton_55() {
		if (button_55 == null) {
			button_55 = new JButton("");
			button_55.setName("58");
			button_55.setBackground(Color.WHITE);
			button_55.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[5][8] == 0) {
						izlazniTokKaServeru.println(button_55.getName());
						button_55.setBackground(new Color(230, 62, 98));
						button_55.setVisible(true);
						button_55.setContentAreaFilled(true);
						button_55.setOpaque(true);
						matrica[5][8] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_55.setMinimumSize(new Dimension(15, 15));
			button_55.setMaximumSize(new Dimension(15, 15));
		}
		return button_55;
	}

	private JButton getButton_56() {
		if (button_56 == null) {
			button_56 = new JButton("");
			button_56.setName("59");
			button_56.setBackground(Color.WHITE);
			button_56.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[5][9] == 0) {
						izlazniTokKaServeru.println(button_56.getName());
						button_56.setBackground(new Color(230, 62, 98));
						button_56.setVisible(true);
						button_56.setContentAreaFilled(true);
						button_56.setOpaque(true);
						matrica[5][9] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_56.setMinimumSize(new Dimension(15, 15));
			button_56.setMaximumSize(new Dimension(15, 15));
		}
		return button_56;
	}

	private JButton getButton_57() {
		if (button_57 == null) {
			button_57 = new JButton("");
			button_57.setName("60");
			button_57.setBackground(Color.WHITE);
			button_57.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[6][0] == 0) {
						izlazniTokKaServeru.println(button_57.getName());
						button_57.setBackground(new Color(230, 62, 98));
						button_57.setVisible(true);
						button_57.setContentAreaFilled(true);
						button_57.setOpaque(true);
						matrica[6][0] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_57.setMinimumSize(new Dimension(15, 15));
			button_57.setMaximumSize(new Dimension(15, 15));
		}
		return button_57;
	}

	private JButton getButton_58() {
		if (button_58 == null) {
			button_58 = new JButton("");
			button_58.setName("61");
			button_58.setBackground(Color.WHITE);
			button_58.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[6][1] == 0) {
						izlazniTokKaServeru.println(button_58.getName());
						button_58.setBackground(new Color(230, 62, 98));
						button_58.setVisible(true);
						button_58.setContentAreaFilled(true);
						button_58.setOpaque(true);
						matrica[6][1] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_58.setMinimumSize(new Dimension(15, 15));
			button_58.setMaximumSize(new Dimension(15, 15));
		}
		return button_58;
	}

	private JButton getButton_59() {
		if (button_59 == null) {
			button_59 = new JButton("");
			button_59.setName("62");
			button_59.setBackground(Color.WHITE);
			button_59.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[6][2] == 0) {
						izlazniTokKaServeru.println(button_50.getName());
						button_59.setBackground(new Color(230, 62, 98));
						button_59.setVisible(true);
						button_59.setContentAreaFilled(true);
						button_59.setOpaque(true);
						matrica[6][2] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_59.setMinimumSize(new Dimension(15, 15));
			button_59.setMaximumSize(new Dimension(15, 15));
		}
		return button_59;
	}

	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("");
			btnNewButton_2.setName("63");
			btnNewButton_2.setBackground(Color.WHITE);
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[6][3] == 0) {
						izlazniTokKaServeru.println(btnNewButton_2.getName());
						btnNewButton_2.setBackground(new Color(230, 62, 98));
						btnNewButton_2.setVisible(true);
						btnNewButton_2.setContentAreaFilled(true);
						btnNewButton_2.setOpaque(true);
						matrica[6][3] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			btnNewButton_2.setMinimumSize(new Dimension(15, 15));
			btnNewButton_2.setMaximumSize(new Dimension(15, 15));
		}
		return btnNewButton_2;
	}

	private JButton getButton_60() {
		if (button_60 == null) {
			button_60 = new JButton("");
			button_60.setName("64");
			button_60.setBackground(Color.WHITE);
			button_60.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[6][4] == 0) {
						izlazniTokKaServeru.println(button_60.getName());
						button_60.setBackground(new Color(230, 62, 98));
						button_60.setVisible(true);
						button_60.setContentAreaFilled(true);
						button_60.setOpaque(true);
						matrica[6][4] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_60.setMinimumSize(new Dimension(15, 15));
			button_60.setMaximumSize(new Dimension(15, 15));
		}
		return button_60;
	}

	private JButton getButton_61() {
		if (button_61 == null) {
			button_61 = new JButton("");
			button_61.setName("65");
			button_61.setBackground(Color.WHITE);
			button_61.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[6][5] == 0) {
						izlazniTokKaServeru.println(button_61.getName());
						button_61.setBackground(new Color(230, 62, 98));
						button_61.setVisible(true);
						button_61.setContentAreaFilled(true);
						button_61.setOpaque(true);
						matrica[6][5] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_61.setMinimumSize(new Dimension(15, 15));
			button_61.setMaximumSize(new Dimension(15, 15));
		}
		return button_61;
	}

	private JButton getButton_62() {
		if (button_62 == null) {
			button_62 = new JButton("");
			button_62.setName("66");
			button_62.setBackground(Color.WHITE);
			button_62.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[6][6] == 0) {
						izlazniTokKaServeru.println(button_62.getName());
						button_62.setBackground(new Color(230, 62, 98));
						button_62.setVisible(true);
						button_62.setContentAreaFilled(true);
						button_62.setOpaque(true);
						matrica[6][6] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_62.setMinimumSize(new Dimension(15, 15));
			button_62.setMaximumSize(new Dimension(15, 15));
		}
		return button_62;
	}

	private JButton getButton_63() {
		if (button_63 == null) {
			button_63 = new JButton("");
			button_63.setName("67");
			button_63.setBackground(Color.WHITE);
			button_63.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[6][7] == 0) {
						izlazniTokKaServeru.println(button_63.getName());
						button_63.setBackground(new Color(230, 62, 98));
						button_63.setVisible(true);
						button_63.setContentAreaFilled(true);
						button_63.setOpaque(true);
						matrica[6][7] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_63.setMaximumSize(new Dimension(15, 15));
			button_63.setMinimumSize(new Dimension(15, 15));
		}
		return button_63;
	}

	private JButton getButton_64() {
		if (button_64 == null) {
			button_64 = new JButton("");
			button_64.setName("68");
			button_64.setBackground(Color.WHITE);
			button_64.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[6][8] == 0) {
						izlazniTokKaServeru.println(button_64.getName());
						button_64.setBackground(new Color(230, 62, 98));
						button_64.setVisible(true);
						button_64.setContentAreaFilled(true);
						button_64.setOpaque(true);
						matrica[6][8] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_64.setMaximumSize(new Dimension(15, 15));
			button_64.setMinimumSize(new Dimension(15, 15));
		}
		return button_64;
	}

	private JButton getButton_65() {
		if (button_65 == null) {
			button_65 = new JButton("");
			button_65.setName("69");
			button_65.setBackground(Color.WHITE);
			button_65.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[6][9] == 0) {
						izlazniTokKaServeru.println(button_65.getName());
						button_65.setBackground(new Color(230, 62, 98));
						button_65.setVisible(true);
						button_65.setContentAreaFilled(true);
						button_65.setOpaque(true);
						matrica[6][9] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_65.setMaximumSize(new Dimension(15, 15));
			button_65.setMinimumSize(new Dimension(15, 15));
		}
		return button_65;
	}

	private JButton getButton_66() {
		if (button_66 == null) {
			button_66 = new JButton("");
			button_66.setName("70");
			button_66.setBackground(Color.WHITE);
			button_66.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[7][0] == 0) {
						izlazniTokKaServeru.println(button_66.getName());
						button_66.setBackground(new Color(230, 62, 98));
						button_66.setVisible(true);
						button_66.setContentAreaFilled(true);
						button_66.setOpaque(true);
						matrica[7][0] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_66.setMaximumSize(new Dimension(15, 15));
			button_66.setMinimumSize(new Dimension(15, 15));
		}
		return button_66;
	}

	private JButton getButton_67() {
		if (button_67 == null) {
			button_67 = new JButton("");
			button_67.setName("71");
			button_67.setBackground(Color.WHITE);
			button_67.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[7][1] == 0) {
						izlazniTokKaServeru.println(button_67.getName());
						button_67.setBackground(new Color(230, 62, 98));
						button_67.setVisible(true);
						button_67.setContentAreaFilled(true);
						button_67.setOpaque(true);
						matrica[7][1] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_67.setMaximumSize(new Dimension(15, 15));
			button_67.setMinimumSize(new Dimension(15, 15));
		}
		return button_67;
	}

	private JButton getButton_68() {
		if (button_68 == null) {
			button_68 = new JButton("");
			button_68.setName("72");
			button_68.setBackground(Color.WHITE);
			button_68.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[7][2] == 0) {
						izlazniTokKaServeru.println(button_68.getName());
						button_68.setBackground(new Color(230, 62, 98));
						button_68.setVisible(true);
						button_68.setContentAreaFilled(true);
						button_68.setOpaque(true);
						matrica[7][2] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_68.setMaximumSize(new Dimension(15, 15));
			button_68.setMinimumSize(new Dimension(15, 15));
		}
		return button_68;
	}

	private JButton getButton_69() {
		if (button_69 == null) {
			button_69 = new JButton("");
			button_69.setName("73");
			button_69.setBackground(Color.WHITE);
			button_69.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[7][3] == 0) {
						izlazniTokKaServeru.println(button_69.getName());
						button_69.setBackground(new Color(230, 62, 98));
						button_69.setVisible(true);
						button_69.setContentAreaFilled(true);
						button_69.setOpaque(true);
						matrica[7][3] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_69.setMinimumSize(new Dimension(15, 15));
			button_69.setMaximumSize(new Dimension(15, 15));
		}
		return button_69;
	}

	private JButton getButton_70() {
		if (button_70 == null) {
			button_70 = new JButton("");
			button_70.setName("74");
			button_70.setBackground(Color.WHITE);
			button_70.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[7][4] == 0) {
						izlazniTokKaServeru.println(button_70.getName());
						button_70.setBackground(new Color(230, 62, 98));
						button_70.setVisible(true);
						button_70.setContentAreaFilled(true);
						button_70.setOpaque(true);
						matrica[7][4] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_70.setMinimumSize(new Dimension(15, 15));
			button_70.setMaximumSize(new Dimension(15, 15));
		}
		return button_70;
	}

	private JButton getButton_71() {
		if (button_71 == null) {
			button_71 = new JButton("");
			button_71.setName("75");
			button_71.setBackground(Color.WHITE);
			button_71.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[7][5] == 0) {
						izlazniTokKaServeru.println(button_71.getName());
						button_71.setBackground(new Color(230, 62, 98));
						button_71.setVisible(true);
						button_71.setContentAreaFilled(true);
						button_71.setOpaque(true);
						matrica[7][5] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_71.setMinimumSize(new Dimension(15, 15));
			button_71.setMaximumSize(new Dimension(15, 15));
		}
		return button_71;
	}

	private JButton getButton_72() {
		if (button_72 == null) {
			button_72 = new JButton("");
			button_72.setName("76");
			button_72.setBackground(Color.WHITE);
			button_72.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[7][6] == 0) {
						izlazniTokKaServeru.println(button_72.getName());
						button_72.setBackground(new Color(230, 62, 98));
						button_72.setVisible(true);
						button_72.setContentAreaFilled(true);
						button_72.setOpaque(true);
						matrica[7][6] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_72.setMinimumSize(new Dimension(15, 15));
			button_72.setMaximumSize(new Dimension(15, 15));
		}
		return button_72;
	}

	private JButton getButton_73() {
		if (button_73 == null) {
			button_73 = new JButton("");
			button_73.setName("77");
			button_73.setBackground(Color.WHITE);
			button_73.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[7][7] == 0) {
						izlazniTokKaServeru.println(button_73.getName());
						button_73.setBackground(new Color(230, 62, 98));
						button_73.setVisible(true);
						button_73.setContentAreaFilled(true);
						button_73.setOpaque(true);
						matrica[7][7] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_73.setMinimumSize(new Dimension(15, 15));
			button_73.setMaximumSize(new Dimension(15, 15));
		}
		return button_73;
	}

	private JButton getButton_74() {
		if (button_74 == null) {
			button_74 = new JButton("");
			button_74.setName("78");
			button_74.setBackground(Color.WHITE);
			button_74.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[7][8] == 0) {
						izlazniTokKaServeru.println(button_74.getName());
						button_74.setBackground(new Color(230, 62, 98));
						button_74.setVisible(true);
						button_74.setContentAreaFilled(true);
						button_74.setOpaque(true);
						matrica[7][8] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_74.setMinimumSize(new Dimension(15, 15));
			button_74.setMaximumSize(new Dimension(15, 15));
		}
		return button_74;
	}

	private JButton getButton_75() {
		if (button_75 == null) {
			button_75 = new JButton("");
			button_75.setName("79");
			button_75.setBackground(Color.WHITE);
			button_75.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[7][9] == 0) {
						izlazniTokKaServeru.println(button_75.getName());
						button_75.setBackground(new Color(230, 62, 98));
						button_75.setVisible(true);
						button_75.setContentAreaFilled(true);
						button_75.setOpaque(true);
						matrica[7][9] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_75.setMinimumSize(new Dimension(15, 15));
			button_75.setMaximumSize(new Dimension(15, 15));
		}
		return button_75;
	}

	private JButton getBtnOdustajem() {
		if (btnOdustajem == null) {
			btnOdustajem = new JButton("Odustajem");
			btnOdustajem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (naPotezu) {
						izlazniTokKaServeru.println("protivnik je pobedio");
						kraj = true;
						JOptionPane.showMessageDialog(frame, "Izgubio/la si. :(", "Kraj igre",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnOdustajem;
	}

	private JButton getButton_76() {
		if (button_76 == null) {
			button_76 = new JButton("");
			button_76.setName("80");
			button_76.setBackground(Color.WHITE);
			button_76.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[8][0] == 0) {
						izlazniTokKaServeru.println(button_76.getName());
						button_76.setBackground(new Color(230, 62, 98));
						button_76.setVisible(true);
						button_76.setContentAreaFilled(true);
						button_76.setOpaque(true);
						matrica[8][0] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_76.setMinimumSize(new Dimension(15, 15));
			button_76.setMaximumSize(new Dimension(15, 15));
		}
		return button_76;
	}

	private JButton getButton_77() {
		if (button_77 == null) {
			button_77 = new JButton("");
			button_77.setName("81");
			button_77.setBackground(Color.WHITE);
			button_77.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[8][1] == 0) {
						izlazniTokKaServeru.println(button_77.getName());
						button_77.setBackground(new Color(230, 62, 98));
						button_77.setVisible(true);
						button_77.setContentAreaFilled(true);
						button_77.setOpaque(true);
						matrica[8][1] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_77.setMinimumSize(new Dimension(15, 15));
			button_77.setMaximumSize(new Dimension(15, 15));
		}
		return button_77;
	}

	private JButton getButton_78() {
		if (button_78 == null) {
			button_78 = new JButton("");
			button_78.setName("82");
			button_78.setBackground(Color.WHITE);
			button_78.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[8][2] == 0) {
						izlazniTokKaServeru.println(button_78.getName());
						button_78.setBackground(new Color(230, 62, 98));
						button_78.setVisible(true);
						button_78.setContentAreaFilled(true);
						button_78.setOpaque(true);
						matrica[8][2] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_78.setMinimumSize(new Dimension(15, 15));
			button_78.setMaximumSize(new Dimension(15, 15));
		}
		return button_78;
	}

	private JButton getButton_79() {
		if (button_79 == null) {
			button_79 = new JButton("");
			button_79.setName("83");
			button_79.setBackground(Color.WHITE);
			button_79.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[8][3] == 0) {
						izlazniTokKaServeru.println(button_79.getName());
						button_79.setBackground(new Color(230, 62, 98));
						button_79.setVisible(true);
						button_79.setContentAreaFilled(true);
						button_79.setOpaque(true);
						matrica[8][3] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_79.setMinimumSize(new Dimension(15, 15));
			button_79.setMaximumSize(new Dimension(15, 15));
		}
		return button_79;
	}

	private JButton getButton_80() {
		if (button_80 == null) {
			button_80 = new JButton("");
			button_80.setName("84");
			button_80.setBackground(Color.WHITE);
			button_80.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[8][4] == 0) {
						izlazniTokKaServeru.println(button_80.getName());
						button_80.setBackground(new Color(230, 62, 98));
						button_80.setVisible(true);
						button_80.setContentAreaFilled(true);
						button_80.setOpaque(true);
						matrica[8][4] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_80.setMinimumSize(new Dimension(15, 15));
			button_80.setMaximumSize(new Dimension(15, 15));
		}
		return button_80;
	}

	private JButton getButton_81() {
		if (button_81 == null) {
			button_81 = new JButton("");
			button_81.setName("85");
			button_81.setBackground(Color.WHITE);
			button_81.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[8][5] == 0) {
						izlazniTokKaServeru.println(button_81.getName());
						button_81.setBackground(new Color(230, 62, 98));
						button_81.setVisible(true);
						button_81.setContentAreaFilled(true);
						button_81.setOpaque(true);
						matrica[8][5] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_81.setMinimumSize(new Dimension(15, 15));
			button_81.setMaximumSize(new Dimension(15, 15));
		}
		return button_81;
	}

	private JButton getButton_82() {
		if (button_82 == null) {
			button_82 = new JButton("");
			button_82.setName("86");
			button_82.setBackground(Color.WHITE);
			button_82.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[8][6] == 0) {
						izlazniTokKaServeru.println(button_82.getName());
						button_82.setBackground(new Color(230, 62, 98));
						button_82.setVisible(true);
						button_82.setContentAreaFilled(true);
						button_82.setOpaque(true);
						matrica[8][6] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_82.setMinimumSize(new Dimension(15, 15));
			button_82.setMaximumSize(new Dimension(15, 15));
		}
		return button_82;
	}

	private JButton getButton_83() {
		if (button_83 == null) {
			button_83 = new JButton("");
			button_83.setName("87");
			button_83.setBackground(Color.WHITE);
			button_83.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[8][7] == 0) {
						izlazniTokKaServeru.println(button_83.getName());
						button_83.setBackground(new Color(230, 62, 98));
						button_83.setVisible(true);
						button_83.setContentAreaFilled(true);
						button_83.setOpaque(true);
						matrica[8][7] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_83.setMinimumSize(new Dimension(15, 15));
			button_83.setMaximumSize(new Dimension(15, 15));
		}
		return button_83;
	}

	private JButton getButton_84() {
		if (button_84 == null) {
			button_84 = new JButton("");
			button_84.setName("88");
			button_84.setBackground(Color.WHITE);
			button_84.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[8][8] == 0) {
						izlazniTokKaServeru.println(button_84.getName());
						button_84.setBackground(new Color(230, 62, 98));
						button_84.setVisible(true);
						button_84.setContentAreaFilled(true);
						button_84.setOpaque(true);
						matrica[8][8] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_84.setMinimumSize(new Dimension(15, 15));
			button_84.setMaximumSize(new Dimension(15, 15));
		}
		return button_84;
	}

	private JButton getButton_85() {
		if (button_85 == null) {
			button_85 = new JButton("");
			button_85.setName("89");
			button_85.setBackground(Color.WHITE);
			button_85.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[8][9] == 0) {
						izlazniTokKaServeru.println(button_85.getName());
						button_85.setBackground(new Color(230, 62, 98));
						button_85.setVisible(true);
						button_85.setContentAreaFilled(true);
						button_85.setOpaque(true);
						matrica[8][9] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_85.setMinimumSize(new Dimension(15, 15));
			button_85.setMaximumSize(new Dimension(15, 15));
		}
		return button_85;
	}

	private JButton getButton_86() {
		if (button_86 == null) {
			button_86 = new JButton("");
			button_86.setName("90");
			button_86.setBackground(Color.WHITE);
			button_86.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[9][0] == 0) {
						izlazniTokKaServeru.println(button_86.getName());
						button_86.setBackground(new Color(230, 62, 98));
						button_86.setVisible(true);
						button_86.setContentAreaFilled(true);
						button_86.setOpaque(true);
						matrica[9][0] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_86.setMaximumSize(new Dimension(15, 15));
			button_86.setMinimumSize(new Dimension(15, 15));
		}
		return button_86;
	}

	private JButton getButton_87() {
		if (button_87 == null) {
			button_87 = new JButton("");
			button_87.setName("91");
			button_87.setBackground(Color.WHITE);
			button_87.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[9][1] == 0) {
						izlazniTokKaServeru.println(button_87.getName());
						button_87.setBackground(new Color(230, 62, 98));
						button_87.setVisible(true);
						button_87.setContentAreaFilled(true);
						button_87.setOpaque(true);
						matrica[9][1] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_87.setMaximumSize(new Dimension(15, 15));
			button_87.setMinimumSize(new Dimension(15, 15));
		}
		return button_87;
	}

	private JButton getButton_88() {
		if (button_88 == null) {
			button_88 = new JButton("");
			button_88.setName("92");
			button_88.setBackground(Color.WHITE);
			button_88.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[9][2] == 0) {
						izlazniTokKaServeru.println(button_88.getName());
						button_88.setBackground(new Color(230, 62, 98));
						button_88.setVisible(true);
						button_88.setContentAreaFilled(true);
						button_88.setOpaque(true);
						matrica[9][2] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_88.setMaximumSize(new Dimension(15, 15));
			button_88.setMinimumSize(new Dimension(15, 15));
		}
		return button_88;
	}

	private JButton getButton_89() {
		if (button_89 == null) {
			button_89 = new JButton("");
			button_89.setName("93");
			button_89.setBackground(Color.WHITE);
			button_89.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[9][3] == 0) {
						izlazniTokKaServeru.println(button_89.getName());
						button_89.setBackground(new Color(230, 62, 98));
						button_89.setVisible(true);
						button_89.setContentAreaFilled(true);
						button_89.setOpaque(true);
						matrica[9][3] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_89.setMaximumSize(new Dimension(15, 15));
			button_89.setMinimumSize(new Dimension(15, 15));
		}
		return button_89;
	}

	private JButton getButton_90() {
		if (button_90 == null) {
			button_90 = new JButton("");
			button_90.setName("94");
			button_90.setBackground(Color.WHITE);
			button_90.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[9][4] == 0) {
						izlazniTokKaServeru.println(button_90.getName());
						button_90.setBackground(new Color(230, 62, 98));
						button_90.setVisible(true);
						button_90.setContentAreaFilled(true);
						button_90.setOpaque(true);
						matrica[9][4] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_90.setMaximumSize(new Dimension(15, 15));
			button_90.setMinimumSize(new Dimension(15, 15));
		}
		return button_90;
	}

	private JButton getButton_91() {
		if (button_91 == null) {
			button_91 = new JButton("");
			button_91.setName("95");
			button_91.setBackground(Color.WHITE);
			button_91.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[9][5] == 0) {
						izlazniTokKaServeru.println(button_91.getName());
						button_91.setBackground(new Color(230, 62, 98));
						button_91.setVisible(true);
						button_91.setContentAreaFilled(true);
						button_91.setOpaque(true);
						matrica[9][5] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_91.setMaximumSize(new Dimension(15, 15));
			button_91.setMinimumSize(new Dimension(15, 15));
		}
		return button_91;
	}

	private JButton getButton_92() {
		if (button_92 == null) {
			button_92 = new JButton("");
			button_92.setName("96");
			button_92.setBackground(Color.WHITE);
			button_92.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[9][6] == 0) {
						izlazniTokKaServeru.println(button_92.getName());
						button_92.setBackground(new Color(230, 62, 98));
						button_92.setVisible(true);
						button_92.setContentAreaFilled(true);
						button_92.setOpaque(true);
						matrica[9][6] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_92.setMaximumSize(new Dimension(15, 15));
			button_92.setMinimumSize(new Dimension(15, 15));
		}
		return button_92;
	}

	private JButton getButton_93() {
		if (button_93 == null) {
			button_93 = new JButton("");
			button_93.setName("97");
			button_93.setBackground(Color.WHITE);
			button_93.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[9][7] == 0) {
						izlazniTokKaServeru.println(button_93.getName());
						button_93.setBackground(new Color(230, 62, 98));
						button_93.setVisible(true);
						button_93.setContentAreaFilled(true);
						button_93.setOpaque(true);
						matrica[9][7] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_93.setMinimumSize(new Dimension(15, 15));
			button_93.setMaximumSize(new Dimension(15, 15));
		}
		return button_93;
	}

	private JButton getButton_94() {
		if (button_94 == null) {
			button_94 = new JButton("");
			button_94.setName("98");
			button_94.setBackground(Color.WHITE);
			button_94.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[9][8] == 0) {
						izlazniTokKaServeru.println(button_94.getName());
						button_94.setBackground(new Color(230, 62, 98));
						button_94.setVisible(true);
						button_94.setContentAreaFilled(true);
						button_94.setOpaque(true);
						matrica[9][8] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_94.setMinimumSize(new Dimension(15, 15));
			button_94.setMaximumSize(new Dimension(15, 15));
		}
		return button_94;
	}

	private JButton getButton_95() {
		if (button_95 == null) {
			button_95 = new JButton("");
			button_95.setName("99");
			button_95.setBackground(Color.WHITE);
			button_95.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (GUI.naPotezu == true && matrica[9][9] == 0) {
						izlazniTokKaServeru.println(button_95.getName());
						button_95.setBackground(new Color(230, 62, 98));
						button_95.setVisible(true);
						button_95.setContentAreaFilled(true);
						button_95.setOpaque(true);
						matrica[9][9] = 1;
						GUI.naPotezu = false;
					}
				}
			});
			button_95.setMinimumSize(new Dimension(15, 15));
			button_95.setMaximumSize(new Dimension(15, 15));
		}
		return button_95;
	}
}