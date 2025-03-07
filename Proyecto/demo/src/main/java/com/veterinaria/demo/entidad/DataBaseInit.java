package com.veterinaria.demo.entidad;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.veterinaria.demo.repositorio.AdministradorRepository;
import com.veterinaria.demo.repositorio.ClienteRepository;
import com.veterinaria.demo.repositorio.FacturaRepository;
import com.veterinaria.demo.repositorio.MascotaRepository;
import com.veterinaria.demo.repositorio.MedicamentoRepository;
import com.veterinaria.demo.repositorio.MetodoPagoRepository;
import com.veterinaria.demo.repositorio.ServicioRepository;
import com.veterinaria.demo.repositorio.TratamientoMedicamentoRepository;
import com.veterinaria.demo.repositorio.TratamientoRepository;
import com.veterinaria.demo.repositorio.VeterinarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Transactional
public class DataBaseInit implements ApplicationRunner {

    private final ClienteRepository clienteRepository;
    private final VeterinarioRepository veterinarioRepository;
    private final AdministradorRepository administradorRepository;
    private final ServicioRepository servicioRepository;
    private final MetodoPagoRepository metodoPagoRepository;
    private final FacturaRepository facturaRepository;
    private final MascotaRepository mascotaRepository;
    private final TratamientoRepository tratamientoRepository;
    private final MedicamentoRepository medicamentoRepository;
    private final TratamientoMedicamentoRepository tratamientoMedicamentoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Creación de clientes
        Cliente cliente1 = new Cliente(null, "Juan Pérez", "juan.perez@gmail.com", "3001234567", "123456789", "juanp", "pass1", null, null);
        clienteRepository.save(cliente1);
        
        Cliente cliente2 = new Cliente(null, "Carlos Gómez", "carlos.gomez@gmail.com", "3112345678", "987654321", "carlosg", "pass2", null, null);
        clienteRepository.save(cliente2);
        
        Cliente cliente3 = new Cliente(null, "Ana Martínez", "ana.martinez@gmail.com", "3223456789", "456789123", "anam", "pass3", null, null);
        clienteRepository.save(cliente3);
        
        Cliente cliente4 = new Cliente(null, "Luis Rodríguez", "luis.rodriguez@gmail.com", "3009876543", "654321987", "luisr", "pass4", null, null);
        clienteRepository.save(cliente4);
        
        Cliente cliente5 = new Cliente(null, "María Fernanda López", "maria.lopez@gmail.com", "3205678901", "741852963", "marial", "pass5", null, null);
        clienteRepository.save(cliente5);
        
        Cliente cliente6 = new Cliente(null, "Pedro Sánchez", "pedro.sanchez@gmail.com", "3216789012", "369258147", "pedros", "pass6", null, null);
        clienteRepository.save(cliente6);
        
        Cliente cliente7 = new Cliente(null, "Laura Torres", "laura.torres@gmail.com", "3127890123", "852741963", "laurat", "pass7", null, null);
        clienteRepository.save(cliente7);
        
        Cliente cliente8 = new Cliente(null, "Ricardo Mendoza", "ricardo.mendoza@gmail.com", "3138901234", "147963852", "ricardom", "pass8", null, null);
        clienteRepository.save(cliente8);
        
        Cliente cliente9 = new Cliente(null, "Sofía Ramírez", "sofia.ramirez@gmail.com", "3149012345", "258147369", "sofiar", "pass9", null, null);
        clienteRepository.save(cliente9);
        
        Cliente cliente10 = new Cliente(null, "Fernando Castillo", "fernando.castillo@gmail.com", "3150123456", "369852741", "fernandoc", "pass10", null, null);
        clienteRepository.save(cliente10);
        
        Cliente cliente11 = new Cliente(null, "Carmen Gutiérrez", "carmen.gutierrez@gmail.com", "3161234567", "741369852", "carmeng", "pass11", null, null);
        clienteRepository.save(cliente11);
        
        Cliente cliente12 = new Cliente(null, "Javier Herrera", "javier.herrera@gmail.com", "3172345678", "852369147", "javierh", "pass12", null, null);
        clienteRepository.save(cliente12);
        
        Cliente cliente13 = new Cliente(null, "Elena Vargas", "elena.vargas@gmail.com", "3183456789", "963741852", "elenav", "pass13", null, null);
        clienteRepository.save(cliente13);
        
        Cliente cliente14 = new Cliente(null, "Raúl Morales", "raul.morales@gmail.com", "3194567890", "147852963", "raulm", "pass14", null, null);
        clienteRepository.save(cliente14);
        
        Cliente cliente15 = new Cliente(null, "Andrea Suárez", "andrea.suarez@gmail.com", "3205678901", "258963741", "andreas", "pass15", null, null);
        clienteRepository.save(cliente15);
        
        Cliente cliente16 = new Cliente(null, "Diego Paredes", "diego.paredes@gmail.com", "3216789012", "369741852", "diegop", "pass16", null, null);
        clienteRepository.save(cliente16);
        
        Cliente cliente17 = new Cliente(null, "Paula Ríos", "paula.rios@gmail.com", "3227890123", "741258963", "paular", "pass17", null, null);
        clienteRepository.save(cliente17);
        
        Cliente cliente18 = new Cliente(null, "Hugo Benítez", "hugo.benitez@gmail.com", "3238901234", "852369741", "hugob", "pass18", null, null);
        clienteRepository.save(cliente18);
        
        Cliente cliente19 = new Cliente(null, "Diana Salazar", "diana.salazar@gmail.com", "3249012345", "963147852", "dianas", "pass19", null, null);
        clienteRepository.save(cliente19);
        
        Cliente cliente20 = new Cliente(null, "Gabriel Flores", "gabriel.flores@gmail.com", "3250123456", "147963258", "gabrielf", "pass20", null, null);
        clienteRepository.save(cliente20);
        
        Cliente cliente21 = new Cliente(null, "Verónica Méndez", "veronica.mendez@gmail.com", "3261234567", "258741369", "veronicam", "pass21", null, null);
        clienteRepository.save(cliente21);
        
        Cliente cliente22 = new Cliente(null, "Francisco Cortés", "francisco.cortes@gmail.com", "3272345678", "369852147", "franciscoc", "pass22", null, null);
        clienteRepository.save(cliente22);
        
        Cliente cliente23 = new Cliente(null, "Julia Ocampo", "julia.ocampo@gmail.com", "3283456789", "741369258", "juliao", "pass23", null, null);
        clienteRepository.save(cliente23);
        
        Cliente cliente24 = new Cliente(null, "Óscar Naranjo", "oscar.naranjo@gmail.com", "3294567890", "852741369", "oscarn", "pass24", null, null);
        clienteRepository.save(cliente24);
        
        Cliente cliente25 = new Cliente(null, "Mónica León", "monica.leon@gmail.com", "3305678901", "963852741", "monical", "pass25", null, null);
        clienteRepository.save(cliente25);
                
        Cliente cliente26 = new Cliente(null, "Renato Villalba", "renato.villalba@gmail.com", "3316789012", "100001", "renatov", "pass26", null, null);
        clienteRepository.save(cliente26);

        Cliente cliente27 = new Cliente(null, "Lucía Méndez", "lucia.mendez@gmail.com", "3327890123", "100002", "luciam", "pass27", null, null);
        clienteRepository.save(cliente27);

        Cliente cliente28 = new Cliente(null, "Emilio Vargas", "emilio.vargas@gmail.com", "3338901234", "100003", "emiliov", "pass28", null, null);
        clienteRepository.save(cliente28);

        Cliente cliente29 = new Cliente(null, "Natalia Ortega", "natalia.ortega@gmail.com", "3349012345", "100004", "nataliao", "pass29", null, null);
        clienteRepository.save(cliente29);

        Cliente cliente30 = new Cliente(null, "Rodrigo Peña", "rodrigo.pena@gmail.com", "3350123456", "100005", "rodrigop", "pass30", null, null);
        clienteRepository.save(cliente30);

        Cliente cliente31 = new Cliente(null, "Valeria Salinas", "valeria.salinas@gmail.com", "3361234567", "100006", "valerias", "pass31", null, null);
        clienteRepository.save(cliente31);

        Cliente cliente32 = new Cliente(null, "Esteban Rojas", "esteban.rojas@gmail.com", "3372345678", "100007", "estebanr", "pass32", null, null);
        clienteRepository.save(cliente32);

        Cliente cliente33 = new Cliente(null, "Isabela Herrera", "isabela.herrera@gmail.com", "3383456789", "100008", "isabelah", "pass33", null, null);
        clienteRepository.save(cliente33);

        Cliente cliente34 = new Cliente(null, "Andrés Molina", "andres.molina@gmail.com", "3394567890", "100009", "andresm", "pass34", null, null);
        clienteRepository.save(cliente34);

        Cliente cliente35 = new Cliente(null, "Camila Fernández", "camila.fernandez@gmail.com", "3405678901", "100010", "camilaf", "pass35", null, null);
        clienteRepository.save(cliente35);

        Cliente cliente36 = new Cliente(null, "Diego Castro", "diego.castro@gmail.com", "3416789012", "100011", "diegoc", "pass36", null, null);
        clienteRepository.save(cliente36);

        Cliente cliente37 = new Cliente(null, "Santiago Ramos", "santiago.ramos@gmail.com", "3427890123", "100012", "santiagor", "pass37", null, null);
        clienteRepository.save(cliente37);

        Cliente cliente38 = new Cliente(null, "Gabriela Ríos", "gabriela.rios@gmail.com", "3438901234", "100013", "gabrielar", "pass38", null, null);
        clienteRepository.save(cliente38);

        Cliente cliente39 = new Cliente(null, "Fernando Ocampo", "fernando.ocampo@gmail.com", "3449012345", "100014", "fernandoo", "pass39", null, null);
        clienteRepository.save(cliente39);

        Cliente cliente40 = new Cliente(null, "Paola González", "paola.gonzalez@gmail.com", "3450123456", "100015", "paolag", "pass40", null, null);
        clienteRepository.save(cliente40);

        Cliente cliente41 = new Cliente(null, "Ricardo Estrada", "ricardo.estrada@gmail.com", "3461234567", "100016", "ricardoe", "pass41", null, null);
        clienteRepository.save(cliente41);

        Cliente cliente42 = new Cliente(null, "Alejandra Campos", "alejandra.campos@gmail.com", "3472345678", "100017", "alejandrac", "pass42", null, null);
        clienteRepository.save(cliente42);

        Cliente cliente43 = new Cliente(null, "Manuel Ortega", "manuel.ortega@gmail.com", "3483456789", "100018", "manuelo", "pass43", null, null);
        clienteRepository.save(cliente43);

        Cliente cliente44 = new Cliente(null, "Beatriz Montes", "beatriz.montes@gmail.com", "3494567890", "100019", "beatrizm", "pass44", null, null);
        clienteRepository.save(cliente44);

        Cliente cliente45 = new Cliente(null, "Joaquín Pacheco", "joaquin.pacheco@gmail.com", "3505678901", "100020", "joaquinp", "pass45", null, null);
        clienteRepository.save(cliente45);

        Cliente cliente46 = new Cliente(null, "Lorena Navarro", "lorena.navarro@gmail.com", "3516789012", "100021", "lorenan", "pass46", null, null);
        clienteRepository.save(cliente46);

        Cliente cliente47 = new Cliente(null, "Cristian Mendoza", "cristian.mendoza@gmail.com", "3527890123", "100022", "cristianm", "pass47", null, null);
        clienteRepository.save(cliente47);

        Cliente cliente48 = new Cliente(null, "Patricia Vargas", "patricia.vargas@gmail.com", "3538901234", "100023", "patriciav", "pass48", null, null);
        clienteRepository.save(cliente48);

        Cliente cliente49 = new Cliente(null, "Fabián Delgado", "fabian.delgado@gmail.com", "3549012345", "100024", "fabiand", "pass49", null, null);
        clienteRepository.save(cliente49);

        Cliente cliente50 = new Cliente(null, "Mariana Bustos", "mariana.bustos@gmail.com", "3550123456", "100025", "marianab", "pass50", null, null);
        clienteRepository.save(cliente50);


        // Creación de veterinarios
        Veterinario veterinario = new Veterinario(null, "Dr. Smith", "123456", "Veterinario General", "foto.png", 1, 10, "drsmith","123", null, null);
        veterinarioRepository.save(veterinario);

        // Creación de administradores
        Administrador administrador = new Administrador(null, "Carlos López", "987654321", "carlos_admin","123");
        administradorRepository.save(administrador);

        // Creación de servicios
        Servicio servicioConsulta = new Servicio(null, "Consulta General", "Revisión general de la mascota", 50000f, null, null, null);
        servicioRepository.save(servicioConsulta);

        // Creación de métodos de pago
        MetodoPago metodoPago = new MetodoPago(null, "Tarjeta de Crédito", null);
        metodoPagoRepository.save(metodoPago);

        // Creación de una factura
        Factura factura = new Factura(null, new Timestamp(new Date().getTime()), 50000f, List.of(metodoPago), List.of(servicioConsulta));
        facturaRepository.save(factura);

        // Creación de una mascota
        Mascota mascota = new Mascota(null, "Firulais", "Labrador", 3, 20.5f, "Ninguna", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Labrador_on_Quantock_%282175262184%29.jpg/640px-Labrador_on_Quantock_%282175262184%29.jpg", new Date(), new Date(), null, 1, cliente1);
        mascotaRepository.save(mascota);
        

        /* Creación de un tratamiento*/ 
        Tratamiento tratamiento = new Tratamiento(null, "TRAT123", new Date(), "Tratamiento básico", veterinario, mascota, servicioConsulta, null);
        tratamientoRepository.save(tratamiento);

        // Creación de un medicamento
        Medicamento medicamento = new Medicamento(null, "Antibiótico", 100.0f, 150.0f, 50, 10, null);
        medicamentoRepository.save(medicamento);

        // Asociación entre tratamiento y medicamento
        TratamientoMedicamento tratamientoMedicamento = new TratamientoMedicamento(null, tratamiento, medicamento, 2);
        tratamientoMedicamentoRepository.save(tratamientoMedicamento);

        System.out.println("Base de datos inicializada con datos de ejemplo.");
    }
}
