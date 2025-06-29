/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 *
 * @author gonza
 */
// Clase de ejemplo para mostrar cómo usar el sistema
// Los estudiantes pueden ver cómo se usan las estructuras de datos
public class EjemploPrueba {
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO DE USO DEL SISTEMA DE TRÁMITES ===\n");
        
        // Crear el sistema
        SistemaTramites sistema = new SistemaTramites();
        
        // Ejemplo 1: Registrar expedientes
        System.out.println("1. REGISTRANDO EXPEDIENTES:");
        System.out.println("----------------------------");
        
        // Crear interesados
        Interesado interesado1 = new Interesado("12345678", "Juan", "Pérez", 
                                               "999888777", "juan.perez@email.com", true);
        Interesado interesado2 = new Interesado("87654321", "María", "García", 
                                               "888777666", "maria.garcia@email.com", false);
        
        // Registrar expedientes
        String id1 = sistema.registrarExpediente(1, interesado1, 
                                                "Solicitud de constancia de estudios", "DOC001");
        String id2 = sistema.registrarExpediente(2, interesado2, 
                                                "Pago de matrícula", "DOC002");
        
        System.out.println("Expediente registrado: " + id1);
        System.out.println("Expediente registrado: " + id2);
        System.out.println();
        
        // Ejemplo 2: Mover expedientes entre dependencias
        System.out.println("2. MOVIENDO EXPEDIENTES:");
        System.out.println("-------------------------");
        
        sistema.moverExpediente(id1, "Secretaría Académica", "Enviado para revisión");
        sistema.moverExpediente(id1, "Decanato", "Aprobado por decano");
        sistema.moverExpediente(id2, "Tesorería", "Pendiente de pago");
        
        System.out.println("Expedientes movidos entre dependencias");
        System.out.println();
        
        // Ejemplo 3: Consultar estado de trámites
        System.out.println("3. CONSULTANDO ESTADO:");
        System.out.println("----------------------");
        
        String estado1 = sistema.obtenerEstadoTramite(id1);
        System.out.println("Estado del expediente " + id1 + ":");
        System.out.println(estado1);
        System.out.println();
        
        // Ejemplo 4: Ver expedientes pendientes
        System.out.println("4. EXPEDIENTES PENDIENTES:");
        System.out.println("--------------------------");
        
        String pendientes = sistema.obtenerExpedientesPendientes();
        System.out.println(pendientes);
        
        // Ejemplo 5: Finalizar un expediente
        System.out.println("5. FINALIZANDO EXPEDIENTE:");
        System.out.println("---------------------------");
        
        sistema.finalizarExpediente(id1);
        System.out.println("Expediente " + id1 + " finalizado");
        System.out.println();
        
        // Ejemplo 6: Ver estadísticas
        System.out.println("6. ESTADÍSTICAS DEL SISTEMA:");
        System.out.println("-----------------------------");
        
        String estadisticas = sistema.obtenerEstadisticas();
        System.out.println(estadisticas);
        System.out.println();
        
        System.out.println("=== FIN DEL EJEMPLO ===");
        System.out.println("\nPara usar la interfaz gráfica, ejecuta: java SistemaTramites");
    }
} 