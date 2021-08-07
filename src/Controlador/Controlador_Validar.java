/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author James Romero
 */
public class Controlador_Validar {

    public void ValidarNumero(KeyEvent num, JTextField txt, int tam) {
        try {
            char c = num.getKeyChar();
            if (!Character.isDigit(c)) {
                num.consume();
            }
            if (txt.getText().length() == tam) {
                num.consume();
                Toolkit.getDefaultToolkit().beep();

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex + "Error");
        }
    }

    public void ValidarLetra(KeyEvent num, JTextField txt, int tam) {
        try {
            char c = num.getKeyChar();
            if (Character.isDigit(c)) {
                num.consume();
            }
            if (txt.getText().length() == tam) {
                num.consume();
                Toolkit.getDefaultToolkit().beep();

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex + "Error");
        }
    }

    public void ValidarNumeroReal(KeyEvent num, JTextField txt, int tam) {

        try {
            char c = num.getKeyChar();

            if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
                    && (c != '.')) {
                num.consume();
            }

            if (c == '.' && txt.getText().contains(".")) {
                num.consume();
            }
            if (txt.getText().length() == tam) {
                num.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex + "Error");
        }
    }

    public String ObtenerCodString(int c) {
        String cdd = "000001";
        if (c < 10) {
            cdd = "00000" + c;
        } else if (c < 100) {
            cdd = "0000" + c;
        } else if (c < 1000) {
            cdd = "000" + c;
        } else if (c < 10000) {
            cdd = "00" + c;
        } else if (c < 100000) {
            cdd = "0" + c;
        } else {
            cdd = "" + c;
        }
        return cdd;
    }

    public boolean validadorDeCedula(String cedula, JTextField txt) {
        boolean cedulaCorrecta = false;
        try {
            if (cedula.length() == 10) {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }
                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Una Excepción Ha Ocurrido En El Proceso de Validacion: " + err.getMessage());
            cedulaCorrecta = false;
        }
        if (!cedulaCorrecta) {
            JOptionPane.showMessageDialog(null, "La Cédula Ingresada Es Incorrecta", "Mensaje", JOptionPane.ERROR_MESSAGE);
            txt.setText("");
            txt.requestFocus();
        }
        return cedulaCorrecta;
    }
    
    

}
