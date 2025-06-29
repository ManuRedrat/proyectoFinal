package com.mycompany.proyectofinal;

// Clase principal del sistema de gestión de trámites
// Los estudiantes pueden ver cómo se integran todas las estructuras de datos
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SistemaTramites {

    // Estructuras de datos principales
    private Lista expedientes;
    private Lista dependencias;
    private Cola expedientesPendientes;
    private Pila historialGeneral;

    // Contador para generar IDs únicos
    private int contadorExpedientes;

    // Constructor
    public SistemaTramites() {
        expedientes = new Lista();
        dependencias = new Lista();
        expedientesPendientes = new Cola();
        historialGeneral = new Pila();
        contadorExpedientes = 1;

        // Agregar algunas dependencias de ejemplo
        inicializarDependencias();
    }

    // Método para inicializar dependencias de ejemplo
    private void inicializarDependencias() {
        dependencias.agregar(new Dependencia("DEP001", "Recepción", "Punto de entrada de trámites", "Ana García"));
        dependencias.agregar(new Dependencia("DEP002", "Secretaría Académica", "Gestión académica", "Carlos López"));
        dependencias.agregar(new Dependencia("DEP003", "Tesorería", "Pagos y finanzas", "María Rodríguez"));
        dependencias.agregar(new Dependencia("DEP004", "Biblioteca", "Servicios bibliotecarios", "Juan Pérez"));
        dependencias.agregar(new Dependencia("DEP005", "Decanato", "Decanato de la facultad", "Dr. Roberto Silva"));
    }

    // Método para registrar un nuevo expediente
    public String registrarExpediente(int prioridad, Interesado interesado,
            String asunto, String documentoReferencia) {
        // Generar ID único
        String id = "EXP" + String.format("%04d", contadorExpedientes++);

        // Crear el expediente
        Expediente expediente = new Expediente(id, prioridad, interesado, asunto, documentoReferencia);

        // Agregar a la lista de expedientes
        expedientes.agregar(expediente);

        // Agregar a la cola de pendientes
        expedientesPendientes.encolar(expediente);

        // Registrar en el historial general
        String movimiento = "Nuevo expediente registrado: " + id + " - " + asunto;
        historialGeneral.push(movimiento);

        return id;
    }

    // Método para mover un expediente entre dependencias
    public boolean moverExpediente(String expedienteId, String dependenciaDestino, String observaciones) {
        // Buscar el expediente
        Expediente expediente = buscarExpediente(expedienteId);
        if (expediente == null) {
            return false;
        }

        // Crear el movimiento
        String dependenciaOrigen = expediente.getDependenciaActual();
        String fechaHora = new Date().toString();
        Movimiento movimiento = new Movimiento(expedienteId, dependenciaOrigen,
                dependenciaDestino, fechaHora, observaciones);

        // Actualizar el expediente
        expediente.setDependenciaActual(dependenciaDestino);
        expediente.agregarMovimiento(movimiento);

        // Cambiar estado a "En Proceso" si no está finalizado
        if (!expediente.getEstado().equals("Finalizado")) {
            expediente.setEstado("En Proceso");
        }

        // Registrar en el historial general
        String registro = "Movimiento: " + expedienteId + " de " + dependenciaOrigen
                + " a " + dependenciaDestino;
        historialGeneral.push(registro);

        return true;
    }

    // Método para finalizar un expediente
    public boolean finalizarExpediente(String expedienteId) {
        Expediente expediente = buscarExpediente(expedienteId);
        if (expediente == null) {
            return false;
        }

        expediente.finalizar();

        // Registrar en el historial general
        String registro = "Expediente finalizado: " + expedienteId;
        historialGeneral.push(registro);

        return true;
    }

    // Método para buscar un expediente por ID
    public Expediente buscarExpediente(String expedienteId) {
        for (int i = 0; i < expedientes.getTamanio(); i++) {
            Expediente exp = (Expediente) expedientes.buscar(i);
            if (exp.getId().equals(expedienteId)) {
                return exp;
            }
        }
        return null;
    }

    // Método para obtener expedientes pendientes
    public String obtenerExpedientesPendientes() {
        if (expedientesPendientes.isEmpty()) {
            return "No hay expedientes pendientes.";
        }

        StringBuilder resultado = new StringBuilder();
        resultado.append("EXPEDIENTES PENDIENTES:\n\n");

        // Crear una cola temporal para no perder los datos
        Cola temp = new Cola();
        int contador = 1;

        while (!expedientesPendientes.isEmpty()) {
            Expediente exp = (Expediente) expedientesPendientes.desencolar();
            if (exp.getEstado().equals("Pendiente") || exp.getEstado().equals("En Proceso")) {
                resultado.append(contador++).append(". ").append(exp.getResumen()).append("\n");
            }
            temp.encolar(exp);
        }

        // Restaurar la cola original
        while (!temp.isEmpty()) {
            expedientesPendientes.encolar(temp.desencolar());
        }

        return resultado.toString();
    }

    // Método para obtener el estado de un trámite
    public String obtenerEstadoTramite(String expedienteId) {
        Expediente expediente = buscarExpediente(expedienteId);
        if (expediente == null) {
            return "Expediente no encontrado.";
        }

        StringBuilder resultado = new StringBuilder();
        resultado.append("ESTADO DEL TRÁMITE:\n\n");
        resultado.append(expediente.toString());
        resultado.append("\n\nHISTORIAL DE MOVIMIENTOS:\n");

        // Mostrar historial de movimientos
        Pila historial = expediente.getHistorialMovimientos();
        if (historial.isEmpty()) {
            resultado.append("Sin movimientos registrados.");
        } else {
            // Crear una pila temporal para mostrar en orden correcto
            Pila temp = new Pila();
            while (!historial.isEmpty()) {
                Movimiento mov = (Movimiento) historial.pop();
                temp.push(mov);
            }

            int contador = 1;
            while (!temp.isEmpty()) {
                Movimiento mov = (Movimiento) temp.pop();
                resultado.append(contador++).append(". ").append(mov.toString()).append("\n\n");
                historial.push(mov);
            }
        }

        return resultado.toString();
    }

    // Método para obtener todas las dependencias
    public String obtenerDependencias() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("DEPENDENCIAS REGISTRADAS:\n\n");

        for (int i = 0; i < dependencias.getTamanio(); i++) {
            Dependencia dep = (Dependencia) dependencias.buscar(i);
            resultado.append(i + 1).append(". ").append(dep.toString()).append("\n\n");
        }

        return resultado.toString();
    }

    // Método para agregar una nueva dependencia
    public void agregarDependencia(String codigo, String nombre, String descripcion, String responsable) {
        Dependencia nuevaDep = new Dependencia(codigo, nombre, descripcion, responsable);
        dependencias.agregar(nuevaDep);

        // Registrar en el historial general
        String registro = "Nueva dependencia agregada: " + nombre;
        historialGeneral.push(registro);
    }

    // Método para obtener estadísticas básicas
    public String obtenerEstadisticas() {
        int totalExpedientes = expedientes.getTamanio();
        int expedientesPendientes = 0;
        int expedientesEnProceso = 0;
        int expedientesFinalizados = 0;

        for (int i = 0; i < expedientes.getTamanio(); i++) {
            Expediente exp = (Expediente) expedientes.buscar(i);
            switch (exp.getEstado()) {
                case "Pendiente":
                    expedientesPendientes++;
                    break;
                case "En Proceso":
                    expedientesEnProceso++;
                    break;
                case "Finalizado":
                    expedientesFinalizados++;
                    break;
            }
        }

        return "ESTADÍSTICAS DEL SISTEMA:\n\n"
                + "Total de expedientes: " + totalExpedientes + "\n"
                + "Expedientes pendientes: " + expedientesPendientes + "\n"
                + "Expedientes en proceso: " + expedientesEnProceso + "\n"
                + "Expedientes finalizados: " + expedientesFinalizados + "\n"
                + "Total de dependencias: " + dependencias.getTamanio() + "\n"
                + "Total de movimientos: " + historialGeneral.getTamanio();
    }

    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        SistemaTramites sistema = new SistemaTramites();
        sistema.mostrarInterfaz();
    }

    // Método para mostrar la interfaz gráfica
    public void mostrarInterfaz() {
        JFrame frame = new JFrame("Sistema de Gestión de Trámites - ULima");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel de título
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("SISTEMA DE GESTIÓN DE TRÁMITES DOCUMENTARIOS");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        // Panel de botones
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnRegistrar = new JButton("Registrar Expediente");
        JButton btnMover = new JButton("Mover Expediente");
        JButton btnFinalizar = new JButton("Finalizar Expediente");
        JButton btnConsultar = new JButton("Consultar Estado");
        JButton btnPendientes = new JButton("Ver Pendientes");
        JButton btnEstadisticas = new JButton("Estadísticas");

        buttonPanel.add(btnRegistrar);
        buttonPanel.add(btnMover);
        buttonPanel.add(btnFinalizar);
        buttonPanel.add(btnConsultar);
        buttonPanel.add(btnPendientes);
        buttonPanel.add(btnEstadisticas);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Área de texto para mostrar resultados
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(600, 300));
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        // Eventos de los botones
        btnRegistrar.addActionListener(e -> mostrarDialogoRegistro(textArea));
        btnMover.addActionListener(e -> mostrarDialogoMovimiento(textArea));
        btnFinalizar.addActionListener(e -> mostrarDialogoFinalizar(textArea));
        btnConsultar.addActionListener(e -> mostrarDialogoConsulta(textArea));
        btnPendientes.addActionListener(e -> textArea.setText(obtenerExpedientesPendientes()));
        btnEstadisticas.addActionListener(e -> textArea.setText(obtenerEstadisticas()));

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // Métodos para mostrar diálogos (simplificados para estudiantes)
    private void mostrarDialogoRegistro(JTextArea textArea) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Registrar Nuevo Expediente");
        dialog.setSize(400, 500);
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Campos del formulario
        JTextField txtDni = new JTextField();
        JTextField txtNombres = new JTextField();
        JTextField txtApellidos = new JTextField();
        JTextField txtTelefono = new JTextField();
        JTextField txtEmail = new JTextField();
        JTextField txtAsunto = new JTextField();
        JTextField txtDocumento = new JTextField();
        JComboBox<String> cmbPrioridad = new JComboBox<>(new String[]{"Alta", "Media", "Baja"});
        JCheckBox chkTrabajador = new JCheckBox("Es trabajador ULima");

        panel.add(new JLabel("DNI:"));
        panel.add(txtDni);
        panel.add(new JLabel("Nombres:"));
        panel.add(txtNombres);
        panel.add(new JLabel("Apellidos:"));
        panel.add(txtApellidos);
        panel.add(new JLabel("Teléfono:"));
        panel.add(txtTelefono);
        panel.add(new JLabel("Email:"));
        panel.add(txtEmail);
        panel.add(new JLabel("Asunto:"));
        panel.add(txtAsunto);
        panel.add(new JLabel("Documento Ref.:"));
        panel.add(txtDocumento);
        panel.add(new JLabel("Prioridad:"));
        panel.add(cmbPrioridad);
        panel.add(new JLabel(""));
        panel.add(chkTrabajador);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> {
            try {
                int prioridad = cmbPrioridad.getSelectedIndex() + 1;
                Interesado interesado = new Interesado(
                        txtDni.getText(), txtNombres.getText(), txtApellidos.getText(),
                        txtTelefono.getText(), txtEmail.getText(), chkTrabajador.isSelected()
                );

                String id = registrarExpediente(prioridad, interesado,
                        txtAsunto.getText(), txtDocumento.getText());

                textArea.setText("Expediente registrado exitosamente con ID: " + id);
                dialog.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage());
            }
        });

        panel.add(btnGuardar);

        dialog.add(panel);
        dialog.setVisible(true);
    }

    private void mostrarDialogoMovimiento(JTextArea textArea) {
        String expedienteId = JOptionPane.showInputDialog("Ingrese el ID del expediente:");
        if (expedienteId == null || expedienteId.trim().isEmpty()) {
            return;
        }

        String dependenciaDestino = JOptionPane.showInputDialog("Ingrese la dependencia destino:");
        if (dependenciaDestino == null || dependenciaDestino.trim().isEmpty()) {
            return;
        }

        String observaciones = JOptionPane.showInputDialog("Ingrese observaciones:");

        if (moverExpediente(expedienteId, dependenciaDestino, observaciones)) {
            textArea.setText("Expediente movido exitosamente.");
        } else {
            textArea.setText("Error: No se pudo mover el expediente.");
        }
    }

    private void mostrarDialogoFinalizar(JTextArea textArea) {
        String expedienteId = JOptionPane.showInputDialog("Ingrese el ID del expediente a finalizar:");
        if (expedienteId == null || expedienteId.trim().isEmpty()) {
            return;
        }

        if (finalizarExpediente(expedienteId)) {
            textArea.setText("Expediente finalizado exitosamente.");
        } else {
            textArea.setText("Error: No se pudo finalizar el expediente.");
        }
    }

    private void mostrarDialogoConsulta(JTextArea textArea) {
        String expedienteId = JOptionPane.showInputDialog("Ingrese el ID del expediente a consultar:");
        if (expedienteId == null || expedienteId.trim().isEmpty()) {
            return;
        }

        String resultado = obtenerEstadoTramite(expedienteId);
        textArea.setText(resultado);
    }
}
