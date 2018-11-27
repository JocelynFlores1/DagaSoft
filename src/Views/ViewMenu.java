/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author Norberto
 */
public class ViewMenu extends javax.swing.JFrame {

    /**
     * Creates new form ViewMenu
     */
    public ViewMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jmInicio = new javax.swing.JMenu();
        jmVentanas = new javax.swing.JMenu();
        jmCompras = new javax.swing.JMenuItem();
        jmVentas = new javax.swing.JMenuItem();
        jmAlmacen = new javax.swing.JMenuItem();
        jmClientes = new javax.swing.JMenuItem();
        jmProveedores = new javax.swing.JMenuItem();
        jmSucursales = new javax.swing.JMenuItem();
        jmEmpleados = new javax.swing.JMenuItem();
        jmAcercaDe = new javax.swing.JMenu();
        jmSesion = new javax.swing.JMenu();
        jmUsuarioSesion = new javax.swing.JMenuItem();
        jmTipoUsuarioSesion = new javax.swing.JMenuItem();
        jmSucursalSesion = new javax.swing.JMenuItem();
        jmCerrarSesion = new javax.swing.JMenuItem();
        jmBD = new javax.swing.JMenu();
        jmRespaldarBd = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jmInicio.setText("Inicio");
        jMenuBar1.add(jmInicio);

        jmVentanas.setText("Ventanas");

        jmCompras.setText("Compras");
        jmVentanas.add(jmCompras);

        jmVentas.setText("Ventas");
        jmVentanas.add(jmVentas);

        jmAlmacen.setText("Almacen");
        jmVentanas.add(jmAlmacen);

        jmClientes.setText("Clientes");
        jmVentanas.add(jmClientes);

        jmProveedores.setText("Proveedores");
        jmVentanas.add(jmProveedores);

        jmSucursales.setText("Sucursales");
        jmVentanas.add(jmSucursales);

        jmEmpleados.setText("Empleados");
        jmVentanas.add(jmEmpleados);

        jMenuBar1.add(jmVentanas);

        jmAcercaDe.setText("Acerca de");
        jMenuBar1.add(jmAcercaDe);

        jmSesion.setText("Sesión");

        jmUsuarioSesion.setText("Usuario");
        jmSesion.add(jmUsuarioSesion);

        jmTipoUsuarioSesion.setText("Tipo de usuario");
        jmSesion.add(jmTipoUsuarioSesion);

        jmSucursalSesion.setText("Sucursal");
        jmSesion.add(jmSucursalSesion);

        jmCerrarSesion.setText("Cerrar sesión");
        jmSesion.add(jmCerrarSesion);

        jMenuBar1.add(jmSesion);

        jmBD.setText("Base de datos");

        jmRespaldarBd.setText("Respaldar");
        jmBD.add(jmRespaldarBd);

        jMenuBar1.add(jmBD);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 975, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenu jmAcercaDe;
    public javax.swing.JMenuItem jmAlmacen;
    public javax.swing.JMenu jmBD;
    public javax.swing.JMenuItem jmCerrarSesion;
    public javax.swing.JMenuItem jmClientes;
    public javax.swing.JMenuItem jmCompras;
    public javax.swing.JMenuItem jmEmpleados;
    public javax.swing.JMenu jmInicio;
    public javax.swing.JMenuItem jmProveedores;
    public javax.swing.JMenuItem jmRespaldarBd;
    private javax.swing.JMenu jmSesion;
    public javax.swing.JMenuItem jmSucursalSesion;
    public javax.swing.JMenuItem jmSucursales;
    public javax.swing.JMenuItem jmTipoUsuarioSesion;
    public javax.swing.JMenuItem jmUsuarioSesion;
    private javax.swing.JMenu jmVentanas;
    public javax.swing.JMenuItem jmVentas;
    // End of variables declaration//GEN-END:variables
}
