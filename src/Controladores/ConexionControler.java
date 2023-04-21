
package Controladores;

import Modelos.Coneccion;
import Modelos.PersonaModel;
import Vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ConexionControler implements ActionListener{
    frmLogIn VistaLogin;
    frmPrincipal VistaPrincipal;
    Coneccion ModeloConexion;
    frmPersonas VistaPersonas;
    PersonaModel ModeloPersona;
  

    public ConexionControler(frmLogIn VistaLogin, frmPrincipal VistaPrincipal, Coneccion ModeloConexion, frmPersonas VistaPersonas, PersonaModel ModeloPersona) {
        this.VistaLogin = VistaLogin;
        this.VistaPrincipal = VistaPrincipal;
        this.ModeloConexion = ModeloConexion;
        this.VistaPersonas = VistaPersonas;
        this.ModeloPersona = ModeloPersona;
        
        //LEVANTAR FORMULARIO PRINCIPAL
        this.VistaPrincipal.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
        this.VistaPrincipal.setVisible(true);
        //Proner a la escucha boton principal
        this.VistaLogin.btnAceptar.addActionListener(this);
        
        this.VistaLogin.setLocationRelativeTo(null);
        this.VistaLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
       if(arg0.getSource() == this.VistaLogin.btnAceptar)
       
       this.ModeloConexion.Conectar(this.VistaLogin.txtUser.getText(),
               this.VistaLogin.txtPass.getText());
       if(ModeloConexion!=null){
           this.VistaLogin.dispose();
           this.VistaPersonas.btnGuardar.addActionListener(this);
           this.VistaPersonas.setLocationRelativeTo(null);
           this.VistaPersonas.setVisible(true);
       }
       if(arg0.getSource()==this.VistaPersonas.btnGuardar){
           //Mandar a guardar el registro
           this.ModeloPersona.GuardarPersona(this.VistaPersonas.txtNombre.getText(), this.VistaPersonas.txtApellido.getText(),
                   this.VistaPersonas.txtTelefono.getText());
       }
    }
}
