package com.veterinaria.demo.entidad;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Collections;
import java.util.Random;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.veterinaria.demo.repositorio.AdministradorRepository;
import com.veterinaria.demo.repositorio.ClienteRepository;
import com.veterinaria.demo.repositorio.CitaRepository;
import com.veterinaria.demo.repositorio.FacturaRepository;
import com.veterinaria.demo.repositorio.MascotaRepository;
import com.veterinaria.demo.repositorio.MedicamentoRepository;
import com.veterinaria.demo.repositorio.MetodoPagoRepository;
import com.veterinaria.demo.repositorio.ServicioRepository;
import com.veterinaria.demo.repositorio.TestimonioRepository;
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
    private final CitaRepository citaRepository;
    private final TestimonioRepository testimonioRepository;
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
        Cliente cliente1 = new Cliente(null, "Juan Pérez", "juan.perez@gmail.com", "3001234567",
                "https://www.mundopsicologos.com/site/article/49504/52397/las-personas-vitamina-0_ai1.jpg",
                "123456789", "juanp", "pass1", null, null);
        clienteRepository.save(cliente1);

        Cliente cliente2 = new Cliente(null, "Carlos Gómez", "carlos.gomez@gmail.com", "3112345678",
                "https://www.donnamoderna.com/content/uploads/2022/07/Donna-sorridente-830x625.jpg",
                "987654321", "carlosg", "pass2", null, null);
        clienteRepository.save(cliente2);

        Cliente cliente3 = new Cliente(null, "Ana Martínez", "ana.martinez@gmail.com", "3223456789",
                "https://www.mundopsicologos.com/site/article/60606/50895/las-10-cualidades-de-una-persona-mas-valoradas-0_ai1.jpg",
                "456789123", "anam", "pass3", null, null);
        clienteRepository.save(cliente3);

        Cliente cliente4 = new Cliente(null, "Luis Rodríguez", "luis.rodriguez@gmail.com", "3009876543",
                "https://www.clarin.com/2023/12/28/k8gOUmfp5_720x0__1.jpg",
                "654321987", "luisr", "pass4", null, null);
        clienteRepository.save(cliente4);

        Cliente cliente5 = new Cliente(null, "María Fernanda López", "maria.lopez@gmail.com", "3205678901",
                "https://concepto.de/wp-content/uploads/2018/08/persona-e1533759204552.jpg",
                "741852963", "marial", "pass5", null, null);
        clienteRepository.save(cliente5);

        Cliente cliente6 = new Cliente(null, "Pedro Sánchez", "pedro.sanchez@gmail.com", "3216789012",
                "https://www.clarin.com/2023/12/01/rhVeUAooY_2000x1500__1.jpg",
                "369258147", "pedros", "pass6", null, null);
        clienteRepository.save(cliente6);

        Cliente cliente7 = new Cliente(null, "Laura Torres", "laura.torres@gmail.com", "3127890123",
                "https://aishlatino.b-cdn.net/wp-content/uploads/2021/11/que-tipo-de-persona-te-gustaria-ser-730x411-SP.jpg",
                "852741963", "laurat", "pass7", null, null);
        clienteRepository.save(cliente7);

        Cliente cliente8 = new Cliente(null, "Ricardo Mendoza", "ricardo.mendoza@gmail.com", "3138901234",
                "https://www.wellme.es/site/article/60493/50775/como-ser-mejor-persona-6-metodos-para-ser-la-mejor-version-de-ti-mismoa-0_ai1.jpg",
                "147963852", "ricardom", "pass8", null, null);
        clienteRepository.save(cliente8);

        Cliente cliente9 = new Cliente(null, "Sofía Ramírez", "sofia.ramirez@gmail.com", "3149012345",
                "https://img.freepik.com/free-psd/portrait-man-teenager-isolated_23-2151745771.jpg",
                "258147369", "sofiar", "pass9", null, null);
        clienteRepository.save(cliente9);

        Cliente cliente10 = new Cliente(null, "Fernando Castillo", "fernando.castillo@gmail.com", "3150123456",
                "https://centrointegraldepsicologia.com/wp-content/uploads/2023/06/El-Sindrome-de-la-Buena-Persona-Los-Limites-Olvidados-1024x576.png",
                "369852741", "fernandoc", "pass10", null, null);
        clienteRepository.save(cliente10);

        Cliente cliente11 = new Cliente(null, "Carmen Gutiérrez", "carmen.gutierrez@gmail.com", "3161234567",
                "https://media.diariouno.com.ar/p/76d6d1fd697f673cf18184008b6b2d09/adjuntos/298/imagenes/009/371/0009371021/1200x0/smart/psicologia-10-claves-buen-personajpg.jpg",
                "741369852", "carmeng", "pass11", null, null);
        clienteRepository.save(cliente11);

        Cliente cliente12 = new Cliente(null, "Javier Herrera", "javier.herrera@gmail.com", "3172345678",
                "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg",
                "852369147", "javierh", "pass12", null, null);
        clienteRepository.save(cliente12);

        Cliente cliente13 = new Cliente(null, "Elena Vargas", "elena.vargas@gmail.com", "3183456789",
                "https://imagenes.eltiempo.com/files/image_1200_535/files/fp/uploads/2024/03/19/65f9d492598ea.r_d.1079-279-5658.jpeg",
                "963741852", "elenav", "pass13", null, null);
        clienteRepository.save(cliente13);

        Cliente cliente14 = new Cliente(null, "Raúl Morales", "raul.morales@gmail.com", "3194567890",
                "https://www.portafolio.co/files/article_new_multimedia/uploads/2024/02/06/65c27d24da9df.jpeg",
                "147852963", "raulm", "pass14", null, null);
        clienteRepository.save(cliente14);

        Cliente cliente15 = new Cliente(null, "Andrea Suárez", "andrea.suarez@gmail.com", "3205678901",
                "https://www.mundopsicologos.com/site/article/49504/52397/las-personas-vitamina-0_ai1.jpg",
                "258963741", "andreas", "pass15", null, null);
        clienteRepository.save(cliente15);

        Cliente cliente16 = new Cliente(null, "Diego Paredes", "diego.paredes@gmail.com", "3216789012",
                "https://concepto.de/wp-content/uploads/2018/08/persona-e1533759204552.jpg",
                "369741852", "diegop", "pass16", null, null);
        clienteRepository.save(cliente16);

        Cliente cliente17 = new Cliente(null, "Paula Ríos", "paula.rios@gmail.com", "3227890123",
                "https://www.mundopsicologos.com/site/article/60606/50895/las-10-cualidades-de-una-persona-mas-valoradas-0_ai1.jpg",
                "741258963", "paular", "pass17", null, null);
        clienteRepository.save(cliente17);

        Cliente cliente18 = new Cliente(null, "Hugo Benítez", "hugo.benitez@gmail.com", "3238901234",
                "https://www.clarin.com/2023/12/28/k8gOUmfp5_720x0__1.jpg",
                "852369741", "hugob", "pass18", null, null);
        clienteRepository.save(cliente18);

        Cliente cliente19 = new Cliente(null, "Diana Salazar", "diana.salazar@gmail.com", "3249012345",
                "https://concepto.de/wp-content/uploads/2018/08/persona-e1533759204552.jpg",
                "963147852", "dianas", "pass19", null, null);
        clienteRepository.save(cliente19);

        Cliente cliente20 = new Cliente(null, "Gabriel Flores", "gabriel.flores@gmail.com", "3250123456",
                "https://www.clarin.com/2023/12/01/rhVeUAooY_2000x1500__1.jpg",
                "147963258", "gabrielf", "pass20", null, null);
        clienteRepository.save(cliente20);

        Cliente cliente21 = new Cliente(null, "Verónica Méndez", "veronica.mendez@gmail.com", "3261234567",
                "https://aishlatino.b-cdn.net/wp-content/uploads/2021/11/que-tipo-de-persona-te-gustaria-ser-730x411-SP.jpg",
                "258741369", "veronicam", "pass21", null, null);
        clienteRepository.save(cliente21);

        Cliente cliente22 = new Cliente(null, "Francisco Cortés", "francisco.cortes@gmail.com", "3272345678",
                "https://www.wellme.es/site/article/60493/50775/como-ser-mejor-persona-6-metodos-para-ser-la-mejor-version-de-ti-mismoa-0_ai1.jpg",
                "369852147", "franciscoc", "pass22", null, null);
        clienteRepository.save(cliente22);

        Cliente cliente23 = new Cliente(null, "Julia Ocampo", "julia.ocampo@gmail.com", "3283456789",
                "https://img.freepik.com/free-psd/portrait-man-teenager-isolated_23-2151745771.jpg",
                "741369258", "juliao", "pass23", null, null);
        clienteRepository.save(cliente23);

        Cliente cliente24 = new Cliente(null, "Óscar Naranjo", "oscar.naranjo@gmail.com", "3294567890",
                "https://img.freepik.com/fotos-premium/retrato-hombre-joven-guapo_53876-38137.jpg?semt=ais_hybrid",
                "852741369", "oscarn", "pass24", null, null);
        clienteRepository.save(cliente24);

        Cliente cliente25 = new Cliente(null, "Mónica León", "monica.leon@gmail.com", "3305678901",
                "https://media.diariouno.com.ar/p/76d6d1fd697f673cf18184008b6b2d09/adjuntos/298/imagenes/009/371/0009371021/1200x0/smart/psicologia-10-claves-buen-personajpg.jpg",
                "963852741", "monical", "pass25", null, null);
        clienteRepository.save(cliente25);

        Cliente cliente26 = new Cliente(null, "Renato Villalba", "renato.villalba@gmail.com", "3316789012",
                "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg",
                "100001", "renatov", "pass26", null, null);
        clienteRepository.save(cliente26);

        Cliente cliente27 = new Cliente(null, "Lucía Méndez", "lucia.mendez@gmail.com", "3327890123",
                "https://imagenes.eltiempo.com/files/image_1200_535/files/fp/uploads/2024/03/19/65f9d492598ea.r_d.1079-279-5658.jpeg",
                "100002", "luciam", "pass27", null, null);
        clienteRepository.save(cliente27);

        Cliente cliente28 = new Cliente(null, "Emilio Vargas", "emilio.vargas@gmail.com", "3338901234",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6TxYHqrtHNmxOgeapPvtw6i9EkKaQ-khhRQ&s",
                "100003", "emiliov", "pass28", null, null);
        clienteRepository.save(cliente28);

        Cliente cliente29 = new Cliente(null, "Natalia Ortega", "natalia.ortega@gmail.com", "3349012345",
                "https://www.mundopsicologos.com/site/article/49504/52397/las-personas-vitamina-0_ai1.jpg",
                "100004", "nataliao", "pass29", null, null);
        clienteRepository.save(cliente29);

        Cliente cliente30 = new Cliente(null, "Rodrigo Peña", "rodrigo.pena@gmail.com", "3350123456",
                "https://www.donnamoderna.com/content/uploads/2022/07/Donna-sorridente-830x625.jpg",
                "100005", "rodrigop", "pass30", null, null);
        clienteRepository.save(cliente30);

        Cliente cliente31 = new Cliente(null, "Valeria Salinas", "valeria.salinas@gmail.com", "3361234567",
                "https://www.mundopsicologos.com/site/article/60606/50895/las-10-cualidades-de-una-persona-mas-valoradas-0_ai1.jpg",
                "100006", "valerias", "pass31", null, null);
        clienteRepository.save(cliente31);

        Cliente cliente32 = new Cliente(null, "Esteban Rojas", "esteban.rojas@gmail.com", "3372345678",
                "https://www.clarin.com/2023/12/28/k8gOUmfp5_720x0__1.jpg",
                "100007", "estebanr", "pass32", null, null);
        clienteRepository.save(cliente32);

        Cliente cliente33 = new Cliente(null, "Isabela Herrera", "isabela.herrera@gmail.com", "3383456789",
                "https://concepto.de/wp-content/uploads/2018/08/persona-e1533759204552.jpg",
                "100008", "isabelah", "pass33", null, null);
        clienteRepository.save(cliente33);

        Cliente cliente34 = new Cliente(null, "Andrés Molina", "andres.molina@gmail.com", "3394567890",
                "https://www.clarin.com/2023/12/01/rhVeUAooY_2000x1500__1.jpg",
                "100009", "andresm", "pass34", null, null);
        clienteRepository.save(cliente34);

        Cliente cliente35 = new Cliente(null, "Camila Fernández", "camila.fernandez@gmail.com", "3405678901",
                "https://aishlatino.b-cdn.net/wp-content/uploads/2021/11/que-tipo-de-persona-te-gustaria-ser-730x411-SP.jpg",
                "100010", "camilaf", "pass35", null, null);
        clienteRepository.save(cliente35);

        Cliente cliente36 = new Cliente(null, "Diego Castro", "diego.castro@gmail.com", "3416789012",
                "https://www.wellme.es/site/article/60493/50775/como-ser-mejor-persona-6-metodos-para-ser-la-mejor-version-de-ti-mismoa-0_ai1.jpg",
                "100011", "diegoc", "pass36", null, null);
        clienteRepository.save(cliente36);

        Cliente cliente37 = new Cliente(null, "Santiago Ramos", "santiago.ramos@gmail.com", "3427890123",
                "https://img.freepik.com/free-psd/portrait-man-teenager-isolated_23-2151745771.jpg",
                "100012", "santiagor", "pass37", null, null);
        clienteRepository.save(cliente37);

        Cliente cliente38 = new Cliente(null, "Gabriela Ríos", "gabriela.rios@gmail.com", "3438901234",
                "https://centrointegraldepsicologia.com/wp-content/uploads/2023/06/El-Sindrome-de-la-Buena-Persona-Los-Limites-Olvidados-1024x576.png",
                "100013", "gabrielar", "pass38", null, null);
        clienteRepository.save(cliente38);

        Cliente cliente39 = new Cliente(null, "Fernando Ocampo", "fernando.ocampo@gmail.com", "3449012345",
                "https://media.diariouno.com.ar/p/76d6d1fd697f673cf18184008b6b2d09/adjuntos/298/imagenes/009/371/0009371021/1200x0/smart/psicologia-10-claves-buen-personajpg.jpg",
                "100014", "fernandoo", "pass39", null, null);
        clienteRepository.save(cliente39);

        Cliente cliente40 = new Cliente(null, "Paola González", "paola.gonzalez@gmail.com", "3450123456",
                "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg",
                "100015", "paolag", "pass40", null, null);
        clienteRepository.save(cliente40);

        Cliente cliente41 = new Cliente(null, "Ricardo Estrada", "ricardo.estrada@gmail.com", "3461234567",
                "https://imagenes.eltiempo.com/files/image_1200_535/files/fp/uploads/2024/03/19/65f9d492598ea.r_d.1079-279-5658.jpeg",
                "100016", "ricardoe", "pass41", null, null);
        clienteRepository.save(cliente41);

        Cliente cliente42 = new Cliente(null, "Alejandra Campos", "alejandra.campos@gmail.com", "3472345678",
                "https://www.portafolio.co/files/article_new_multimedia/uploads/2024/02/06/65c27d24da9df.jpeg",
                "100017", "alejandrac", "pass42", null, null);
        clienteRepository.save(cliente42);

        Cliente cliente43 = new Cliente(null, "Manuel Ortega", "manuel.ortega@gmail.com", "3483456789",
                "https://www.mundopsicologos.com/site/article/49504/52397/las-personas-vitamina-0_ai1.jpg",
                "100018", "manuelo", "pass43", null, null);
        clienteRepository.save(cliente43);

        Cliente cliente44 = new Cliente(null, "Beatriz Montes", "beatriz.montes@gmail.com", "3494567890",
                "https://www.donnamoderna.com/content/uploads/2022/07/Donna-sorridente-830x625.jpg",
                "100019", "beatrizm", "pass44", null, null);
        clienteRepository.save(cliente44);

        Cliente cliente45 = new Cliente(null, "Joaquín Pacheco", "joaquin.pacheco@gmail.com", "3505678901",
                "https://www.mundopsicologos.com/site/article/60606/50895/las-10-cualidades-de-una-persona-mas-valoradas-0_ai1.jpg",
                "100020", "joaquinp", "pass45", null, null);
        clienteRepository.save(cliente45);

        Cliente cliente46 = new Cliente(null, "Lorena Navarro", "lorena.navarro@gmail.com", "3516789012",
                "https://www.clarin.com/2023/12/28/k8gOUmfp5_720x0__1.jpg",
                "100021", "lorenan", "pass46", null, null);
        clienteRepository.save(cliente46);

        Cliente cliente47 = new Cliente(null, "Cristian Mendoza", "cristian.mendoza@gmail.com", "3527890123",
                "https://concepto.de/wp-content/uploads/2018/08/persona-e1533759204552.jpg",
                "100022", "cristianm", "pass47", null, null);
        clienteRepository.save(cliente47);

        Cliente cliente48 = new Cliente(null, "Patricia Vargas", "patricia.vargas@gmail.com", "3538901234",
                "https://www.clarin.com/2023/12/01/rhVeUAooY_2000x1500__1.jpg",
                "100023", "patriciav", "pass48", null, null);
        clienteRepository.save(cliente48);

        Cliente cliente49 = new Cliente(null, "Fabián Delgado", "fabian.delgado@gmail.com", "3549012345",
                "https://aishlatino.b-cdn.net/wp-content/uploads/2021/11/que-tipo-de-persona-te-gustaria-ser-730x411-SP.jpg",
                "100024", "fabiand", "pass49", null, null);
        clienteRepository.save(cliente49);

        Cliente cliente50 = new Cliente(null, "Mariana Bustos", "mariana.bustos@gmail.com", "3550123456",
                "https://www.wellme.es/site/article/60493/50775/como-ser-mejor-persona-6-metodos-para-ser-la-mejor-version-de-ti-mismoa-0_ai1.jpg",
                "100025", "marianab", "pass50", null, null);
        clienteRepository.save(cliente50);

        // Creación de veterinarios
        Veterinario veterinario1 = new Veterinario(null, "Dra. Martínez", "654321", "Especialista en Cirugía",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDcaEWpYQklMDUzSJPss_l5V9T7yC2xtK7OA&s",
                "Los Pinos", 1, 12, "vet1", "pass1", null, null);
        veterinarioRepository.save(veterinario1);

        Veterinario veterinario2 = new Veterinario(null, "Dr. Gómez", "789012", "Dermatología Veterinaria",
                "https://images.freeimages.com/images/premium/previews/1916/19167116-male-vet-in-lab-coat-with-cat.jpg",
                "Los Pinos", 1, 8, "vet2", "pass2", null, null);
        veterinarioRepository.save(veterinario2);

        Veterinario veterinario3 = new Veterinario(null, "Dra. Fernández", "345678", "Cardiología Veterinaria",
                "https://media.istockphoto.com/id/1995860815/es/foto/mujer-veterinaria-sosteniendo-al-perro-jack-russell.jpg?s=612x612&w=0&k=20&c=ZLFwLWVnPXnCx876vI312OhVUUOEU5Z_9ZHQfvBS4jk=",
                "Los Pinos", 0, 15, "vet3", "pass3", null, null);
        veterinarioRepository.save(veterinario3);

        Veterinario veterinario4 = new Veterinario(null, "Dr. Rodríguez", "901234", "Neurología Veterinaria",
                "https://www.shutterstock.com/image-photo/senior-greyhaired-man-wearing-veterinarian-260nw-2163179989.jpg",
                "Patitas Felices", 1, 20, "vet4", "pass4", null, null);
        veterinarioRepository.save(veterinario4);

        Veterinario veterinario5 = new Veterinario(null, "Dra. López", "567890", "Especialista en Animales Exóticos",
                "https://i0.wp.com/blog.leasemd.mx/wp-content/uploads/2023/10/Leasing-Equipos-Veterinarios-Mexico.png?fit=800%2C533&ssl=1",
                "Patitas Felices", 0, 18, "vet5", "pass5", null, null);
        veterinarioRepository.save(veterinario5);

        Veterinario veterinario6 = new Veterinario(null, "Dr. Ramírez", "678901", "Cirujano Veterinario",
                "https://www.diarioveterinario.com/images/showid2/2860071?w=900&mh=700",
                "Patitas Felices", 1, 15, "vet6", "pass6", null, null);
        veterinarioRepository.save(veterinario6);

        Veterinario veterinario7 = new Veterinario(null, "Dra. Fernández", "789012", "Especialista en Animales de Granja",
                "https://sumimascotas.com/wp-content/uploads/2023/05/9.Dia-del-Veterinario-Colombia-1.jpg",
                "Huellas", 0, 20, "vet7", "pass7", null, null);
        veterinarioRepository.save(veterinario7);

        Veterinario veterinario8 = new Veterinario(null, "Dr. Morales", "890123", "Dermatólogo Veterinario",
                "https://blog.agrovetmarket.com/wp-content/uploads/2020/05/vet.jpg",
                "Huellas", 1, 12, "vet8", "pass8", null, null);
        veterinarioRepository.save(veterinario8);

        Veterinario veterinario9 = new Veterinario(null, "Dra. Castillo", "901234", "Especialista en Rehabilitación Animal",
                "https://cdn0.expertoanimal.com/es/posts/3/6/3/cuando_llevar_a_mi_cachorro_al_veterinario_por_primera_vez_23363_600_square.jpg",
                "Huellas", 0, 10, "vet9", "pass9", null, null);
        veterinarioRepository.save(veterinario9);

        Veterinario veterinario10 = new Veterinario(null, "Dr. Pérez", "012345", "Especialista en Cirugía",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSN6GFsKiPWtTdAKZyKXFQj1P8L7BZkX2ziLb1thmXaYtGlJlJirPSlaG8bKB6i7hRrLJY&usqp=CAU",
                "Huellas", 1, 8, "vet10", "pass10", null, null);
        veterinarioRepository.save(veterinario10);

        // Creación de administrador
        Administrador administrador = new Administrador(null, "Carlos López", "carlosl@gmail.com",
                "https://portal.unbosque.edu.co/sites/default/files/inline-images/en-que-puede-trabajar-un-administrador-de-empresas.jpg",
                "987654321", "admin", "123");
        administradorRepository.save(administrador);

        // Creación de servicios con imágenes
        Servicio servicioConsulta = new Servicio(
                null, 
                "Consulta General", 
                "Realizamos chequeos completos para garantizar la salud de tu mascota.", 
                50000f,
                "https://i.postimg.cc/WbXq7Lwq/consulta.png",
                "https://i.postimg.cc/WbXq7Lwq/consulta.png",
                null, null, null
        );
        servicioRepository.save(servicioConsulta);
        
        Servicio servicioCirugia = new Servicio(
                null, 
                "Cirugía", 
                "Contamos con quirófanos equipados para procedimientos seguros.", 
                70000f,
                "https://i.postimg.cc/Fs9Jcs3Q/cirugia.png",
                "https://i.postimg.cc/Fs9Jcs3Q/cirugia.png",
                null, null, null
        );
        servicioRepository.save(servicioCirugia);
        
        Servicio servicioEstetica = new Servicio(
                null, 
                "Estética y peluquería", 
                "Ofrecemos servicios de baño, cortes de pelo y cuidado estético.", 
                20000f,
                "https://i.postimg.cc/J0dmGqj0/estetica.png",
                "https://i.postimg.cc/J0dmGqj0/estetica.png",
                null, null, null
        );
        servicioRepository.save(servicioEstetica);
        
        Servicio servicioHospitalizacion = new Servicio(
                null, 
                "Hospitalización", 
                "Brindamos hospitalización para garantizar la recuperación de tu mascota.", 
                65000f,
                "https://i.postimg.cc/mgkzXXmX/hospital.png",
                "https://i.postimg.cc/mgkzXXmX/hospital.png",
                null, null, null
        );
        servicioRepository.save(servicioHospitalizacion);
        
        Servicio servicioMonitoreo = new Servicio(
                null, 
                "Monitoreo", 
                "Seguimiento continuo para supervisar el estado de salud de tu mascota.", 
                15000f,
                "https://i.postimg.cc/sDvsbkRh/monitoreo.png",
                "https://i.postimg.cc/sDvsbkRh/monitoreo.png",
                null, null, null
        );
        servicioRepository.save(servicioMonitoreo);
        
        Servicio servicioVacunacion = new Servicio(
                null, 
                "Vacunación", 
                "Ofrecemos una amplia gama de vacunas para mantener a tu mascota protegida y saludable.", 
                5000f,
                "https://i.postimg.cc/L4ymCHGS/vacunacion.png",
                "https://i.postimg.cc/L4ymCHGS/vacunacion.png",
                null, null, null
        );
        servicioRepository.save(servicioVacunacion);
        
        Servicio servicioLaboratorio = new Servicio(
                null, 
                "Laboratorio clínico", 
                "Realizamos pruebas de laboratorio para diagnosticar y prevenir enfermedades.", 
                25500f,
                "https://i.postimg.cc/rw4cw5sy/lab.png",
                "https://i.postimg.cc/rw4cw5sy/lab.png",
                null, null, null
        );
        servicioRepository.save(servicioLaboratorio);
        
        Servicio servicioRehabilitacion = new Servicio(
                null, 
                "Rehabilitación", 
                "Ofrecemos terapias físicas y rehabilitación para mejorar la movilidad y calidad de vida de tu mascota.", 
                22500f,
                "https://i.postimg.cc/WbXq7Lwq/consulta.png", // Imagen por defecto
                "https://i.postimg.cc/WbXq7Lwq/consulta.png", // Imagen por defecto
                null, null, null
        );
        servicioRepository.save(servicioRehabilitacion);

        // Creación de métodos de pago
        MetodoPago metodoPago = new MetodoPago(null, "Tarjeta de Crédito", null);
        metodoPagoRepository.save(metodoPago);

        MetodoPago metodoPago2 = new MetodoPago(null, "Tarjeta de Débito", null);
        metodoPagoRepository.save(metodoPago2);

        MetodoPago metodoPago3 = new MetodoPago(null, "PSE", null);
        metodoPagoRepository.save(metodoPago3);

        MetodoPago metodoPago4 = new MetodoPago(null, "Efectivo", null);
        metodoPagoRepository.save(metodoPago4);

        MetodoPago metodoPago5 = new MetodoPago(null, "Transferencia bancaria", null);
        metodoPagoRepository.save(metodoPago5);

        // Creación de una factura
        Factura factura = new Factura(null, new Timestamp(new Date().getTime()), 50000f, List.of(metodoPago),
                List.of(servicioConsulta));
        facturaRepository.save(factura);

        // Creación de mascotas
        Mascota mascota1 = new Mascota(null, "Firulais", "Labrador", 3, 20.5f, "Otitis",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 0, cliente2);
        mascotaRepository.save(mascota1);

        Mascota mascota2 = new Mascota(null, "Max", "Bulldog", 2, 15.0f, "Problemas respiratorios",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente2);
        mascotaRepository.save(mascota2);

        Mascota mascota3 = new Mascota(null, "Luna", "Beagle", 4, 12.3f, "Alergia alimentaria",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 0, cliente2);
        mascotaRepository.save(mascota3);

        Mascota mascota4 = new Mascota(null, "Rocky", "Golden Retriever", 5, 25.0f, "Displasia de cadera",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente2);
        mascotaRepository.save(mascota4);

        Mascota mascota5 = new Mascota(null, "Bella", "Poodle", 2, 8.5f, "Problemas dentales",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 0, cliente2);
        mascotaRepository.save(mascota5);

        Mascota mascota6 = new Mascota(null, "Toby", "Chihuahua", 1, 3.0f, "Hipoglucemia",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 0,
                cliente2);
        mascotaRepository.save(mascota6);

        Mascota mascota7 = new Mascota(null, "Daisy", "Dálmata", 3, 18.0f, "Sordera congénita",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente7);
        mascotaRepository.save(mascota7);

        Mascota mascota8 = new Mascota(null, "Charlie", "Boxer", 4, 22.0f, "Cardiopatía",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente8);
        mascotaRepository.save(mascota8);

        Mascota mascota9 = new Mascota(null, "Molly", "Shiba Inu", 2, 10.0f, "Dermatitis",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente21);
        mascotaRepository.save(mascota9);

        Mascota mascota10 = new Mascota(null, "Buddy", "Husky", 3, 19.5f, "Hipotiroidismo",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente10);
        mascotaRepository.save(mascota10);

        Mascota mascota11 = new Mascota(null, "Lola", "Bulldog Francés", 2, 12.0f, "Problemas oculares",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 0, cliente11);
        mascotaRepository.save(mascota11);

        Mascota mascota12 = new Mascota(null, "Zeus", "Pastor Alemán", 4, 28.0f, "Displasia de codo",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente12);
        mascotaRepository.save(mascota12);

        Mascota mascota13 = new Mascota(null, "Coco", "Labrador", 3, 20.5f, "Obesidad",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente13);
        mascotaRepository.save(mascota13);

        Mascota mascota14 = new Mascota(null, "Milo", "Beagle", 2, 11.0f, "Epilepsia",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente14);
        mascotaRepository.save(mascota14);

        Mascota mascota15 = new Mascota(null, "Ruby", "Golden Retriever", 5, 24.0f, "Artritis",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente15);
        mascotaRepository.save(mascota15);

        Mascota mascota16 = new Mascota(null, "Oscar", "Poodle", 1, 7.0f, "Problemas renales",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente16);
        mascotaRepository.save(mascota16);

        Mascota mascota17 = new Mascota(null, "Lucky", "Chihuahua", 2, 4.0f, "Luxación de rótula",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente17);
        mascotaRepository.save(mascota17);

        Mascota mascota18 = new Mascota(null, "Rex", "Dálmata", 3, 17.0f, "Cálculos urinarios",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente18);
        mascotaRepository.save(mascota18);

        Mascota mascota19 = new Mascota(null, "Sasha", "Boxer", 4, 21.0f, "Problemas cardíacos",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente19);
        mascotaRepository.save(mascota19);

        Mascota mascota20 = new Mascota(null, "Bruno", "Shiba Inu", 2, 9.5f, "Alergia al polen",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente20);
        mascotaRepository.save(mascota20);

        Mascota mascota21 = new Mascota(null, "Lola", "Bulldog", 3, 14.0f, "Problemas de piel",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente21);
        mascotaRepository.save(mascota21);

        Mascota mascota22 = new Mascota(null, "Thor", "Pastor Belga", 4, 26.0f, "Displasia de cadera",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente22);
        mascotaRepository.save(mascota22);

        Mascota mascota23 = new Mascota(null, "Mia", "Beagle", 2, 10.5f, "Problemas digestivos",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente23);
        mascotaRepository.save(mascota23);

        Mascota mascota24 = new Mascota(null, "Simba", "Golden Retriever", 5, 23.0f, "Cáncer",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente24);
        mascotaRepository.save(mascota24);

        Mascota mascota25 = new Mascota(null, "Nala", "Poodle", 1, 6.5f, "Problemas de tiroides",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente25);
        mascotaRepository.save(mascota25);

        Mascota mascota26 = new Mascota(null, "Roco", "Chihuahua", 2, 3.5f, "Problemas de conducta",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente26);
        mascotaRepository.save(mascota26);

        Mascota mascota27 = new Mascota(null, "Luna", "Dálmata", 3, 16.0f, "Problemas hepáticos",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente27);
        mascotaRepository.save(mascota27);

        Mascota mascota28 = new Mascota(null, "Rocky", "Boxer", 4, 20.0f, "Problemas respiratorios",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente28);
        mascotaRepository.save(mascota28);

        Mascota mascota29 = new Mascota(null, "Bella", "Shiba Inu", 2, 9.0f, "Problemas de ansiedad",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente29);
        mascotaRepository.save(mascota29);

        Mascota mascota30 = new Mascota(null, "Max", "Husky", 3, 18.5f, "Problemas de visión",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente30);
        mascotaRepository.save(mascota30);

        Mascota mascota31 = new Mascota(null, "Daisy", "Bulldog Francés", 2, 13.0f, "Problemas de audición",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente31);
        mascotaRepository.save(mascota31);

        Mascota mascota32 = new Mascota(null, "Zeus", "Pastor Alemán", 4, 27.0f, "Problemas de cadera",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente32);
        mascotaRepository.save(mascota32);

        Mascota mascota33 = new Mascota(null, "Coco", "Labrador", 3, 19.5f, "Problemas de peso",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente33);
        mascotaRepository.save(mascota33);

        Mascota mascota34 = new Mascota(null, "Milo", "Beagle", 2, 10.0f, "Problemas de alergia",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente34);
        mascotaRepository.save(mascota34);

        Mascota mascota35 = new Mascota(null, "Ruby", "Golden Retriever", 5, 22.0f, "Problemas de articulaciones",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente35);
        mascotaRepository.save(mascota35);

        Mascota mascota36 = new Mascota(null, "Oscar", "Poodle", 1, 6.0f, "Problemas de piel",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente36);
        mascotaRepository.save(mascota36);

        Mascota mascota37 = new Mascota(null, "Lucky", "Chihuahua", 2, 3.2f, "Problemas de ansiedad",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente37);
        mascotaRepository.save(mascota37);

        Mascota mascota38 = new Mascota(null, "Rex", "Dálmata", 3, 15.5f, "Problemas de audición",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente38);
        mascotaRepository.save(mascota38);

        Mascota mascota39 = new Mascota(null, "Sasha", "Boxer", 4, 19.0f, "Problemas cardíacos",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente39);
        mascotaRepository.save(mascota39);

        Mascota mascota40 = new Mascota(null, "Bruno", "Shiba Inu", 2, 8.5f, "Problemas de tiroides",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente40);
        mascotaRepository.save(mascota40);

        Mascota mascota41 = new Mascota(null, "Lola", "Bulldog", 3, 13.5f, "Problemas de piel",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente41);
        mascotaRepository.save(mascota41);

        Mascota mascota42 = new Mascota(null, "Thor", "Pastor Belga", 4, 25.5f, "Displasia de cadera",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente42);
        mascotaRepository.save(mascota42);

        Mascota mascota43 = new Mascota(null, "Mia", "Beagle", 2, 9.8f, "Problemas digestivos",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente43);
        mascotaRepository.save(mascota43);

        Mascota mascota44 = new Mascota(null, "Simba", "Golden Retriever", 5, 21.5f, "Cáncer",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente44);
        mascotaRepository.save(mascota44);

        Mascota mascota45 = new Mascota(null, "Nala", "Poodle", 1, 5.5f, "Problemas de tiroides",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente45);
        mascotaRepository.save(mascota45);

        Mascota mascota46 = new Mascota(null, "Roco", "Chihuahua", 2, 3.0f, "Problemas de conducta",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente46);
        mascotaRepository.save(mascota46);

        Mascota mascota47 = new Mascota(null, "Luna", "Dálmata", 3, 14.5f, "Problemas hepáticos",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente47);
        mascotaRepository.save(mascota47);

        Mascota mascota48 = new Mascota(null, "Rocky", "Boxer", 4, 18.0f, "Problemas respiratorios",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente48);
        mascotaRepository.save(mascota48);

        Mascota mascota49 = new Mascota(null, "Bella", "Shiba Inu", 2, 8.0f, "Problemas de ansiedad",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente49);
        mascotaRepository.save(mascota49);

        Mascota mascota50 = new Mascota(null, "Max", "Husky", 3, 17.5f, "Problemas de visión",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente50);
        mascotaRepository.save(mascota50);

        Mascota mascota51 = new Mascota(null, "Toby", "Labrador", 4, 22.0f, "Problemas de piel",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente1);
        mascotaRepository.save(mascota51);

        Mascota mascota52 = new Mascota(null, "Luna", "Bulldog", 3, 16.0f, "Problemas respiratorios",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente2);
        mascotaRepository.save(mascota52);

        Mascota mascota53 = new Mascota(null, "Rocky", "Beagle", 2, 11.5f, "Alergia alimentaria",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente3);
        mascotaRepository.save(mascota53);

        Mascota mascota54 = new Mascota(null, "Bella", "Golden Retriever", 5, 26.0f, "Displasia de cadera",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente4);
        mascotaRepository.save(mascota54);

        Mascota mascota55 = new Mascota(null, "Max", "Poodle", 1, 7.5f, "Problemas dentales",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente5);
        mascotaRepository.save(mascota55);

        Mascota mascota56 = new Mascota(null, "Daisy", "Chihuahua", 2, 3.5f, "Hipoglucemia",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente6);
        mascotaRepository.save(mascota56);

        Mascota mascota57 = new Mascota(null, "Charlie", "Dálmata", 4, 19.0f, "Sordera congénita",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente7);
        mascotaRepository.save(mascota57);

        Mascota mascota58 = new Mascota(null, "Molly", "Boxer", 3, 21.5f, "Cardiopatía",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente8);
        mascotaRepository.save(mascota58);

        Mascota mascota59 = new Mascota(null, "Buddy", "Shiba Inu", 2, 10.5f, "Dermatitis",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente9);
        mascotaRepository.save(mascota59);

        Mascota mascota60 = new Mascota(null, "Lola", "Husky", 3, 18.0f, "Hipotiroidismo",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente10);
        mascotaRepository.save(mascota60);

        Mascota mascota61 = new Mascota(null, "Zeus", "Bulldog Francés", 4, 13.5f, "Problemas oculares",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente11);
        mascotaRepository.save(mascota61);

        Mascota mascota62 = new Mascota(null, "Coco", "Pastor Alemán", 5, 27.5f, "Displasia de codo",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente12);
        mascotaRepository.save(mascota62);

        Mascota mascota63 = new Mascota(null, "Milo", "Labrador", 2, 20.0f, "Obesidad",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente13);
        mascotaRepository.save(mascota63);

        Mascota mascota64 = new Mascota(null, "Ruby", "Beagle", 3, 12.0f, "Epilepsia",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente14);
        mascotaRepository.save(mascota64);

        Mascota mascota65 = new Mascota(null, "Oscar", "Golden Retriever", 4, 23.5f, "Artritis",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente15);
        mascotaRepository.save(mascota65);

        Mascota mascota66 = new Mascota(null, "Lucky", "Poodle", 1, 6.5f, "Problemas renales",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente16);
        mascotaRepository.save(mascota66);

        Mascota mascota67 = new Mascota(null, "Rex", "Chihuahua", 2, 4.5f, "Luxación de rótula",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente17);
        mascotaRepository.save(mascota67);

        Mascota mascota68 = new Mascota(null, "Sasha", "Dálmata", 3, 16.5f, "Cálculos urinarios",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente18);
        mascotaRepository.save(mascota68);

        Mascota mascota69 = new Mascota(null, "Bruno", "Boxer", 4, 20.5f, "Problemas cardíacos",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente19);
        mascotaRepository.save(mascota69);

        Mascota mascota70 = new Mascota(null, "Lola", "Shiba Inu", 2, 9.0f, "Alergia al polen",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente20);
        mascotaRepository.save(mascota70);

        Mascota mascota71 = new Mascota(null, "Thor", "Bulldog", 3, 14.5f, "Problemas de piel",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente21);
        mascotaRepository.save(mascota71);

        Mascota mascota72 = new Mascota(null, "Mia", "Pastor Belga", 4, 25.0f, "Displasia de cadera",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente22);
        mascotaRepository.save(mascota72);

        Mascota mascota73 = new Mascota(null, "Simba", "Beagle", 2, 10.0f, "Problemas digestivos",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente23);
        mascotaRepository.save(mascota73);

        Mascota mascota74 = new Mascota(null, "Nala", "Golden Retriever", 5, 24.0f, "Cáncer",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente24);
        mascotaRepository.save(mascota74);

        Mascota mascota75 = new Mascota(null, "Roco", "Poodle", 1, 5.0f, "Problemas de tiroides",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente25);
        mascotaRepository.save(mascota75);

        Mascota mascota76 = new Mascota(null, "Luna", "Chihuahua", 2, 3.8f, "Problemas de conducta",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente26);
        mascotaRepository.save(mascota76);

        Mascota mascota77 = new Mascota(null, "Rocky", "Dálmata", 3, 15.0f, "Problemas hepáticos",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente27);
        mascotaRepository.save(mascota77);

        Mascota mascota78 = new Mascota(null, "Bella", "Boxer", 4, 19.5f, "Problemas respiratorios",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente28);
        mascotaRepository.save(mascota78);

        Mascota mascota79 = new Mascota(null, "Max", "Shiba Inu", 2, 8.8f, "Problemas de ansiedad",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente29);
        mascotaRepository.save(mascota79);

        Mascota mascota80 = new Mascota(null, "Daisy", "Husky", 3, 17.0f, "Problemas de visión",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente30);
        mascotaRepository.save(mascota80);

        Mascota mascota81 = new Mascota(null, "Charlie", "Bulldog Francés", 2, 12.5f, "Problemas de audición",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente31);
        mascotaRepository.save(mascota81);

        Mascota mascota82 = new Mascota(null, "Molly", "Pastor Alemán", 4, 26.5f, "Problemas de cadera",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente32);
        mascotaRepository.save(mascota82);

        Mascota mascota83 = new Mascota(null, "Buddy", "Labrador", 3, 20.0f, "Problemas de peso",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente33);
        mascotaRepository.save(mascota83);

        Mascota mascota84 = new Mascota(null, "Lola", "Beagle", 2, 11.0f, "Problemas de alergia",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente34);
        mascotaRepository.save(mascota84);

        Mascota mascota85 = new Mascota(null, "Zeus", "Golden Retriever", 5, 22.5f, "Problemas de articulaciones",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente35);
        mascotaRepository.save(mascota85);

        Mascota mascota86 = new Mascota(null, "Coco", "Poodle", 1, 6.8f, "Problemas de piel",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente36);
        mascotaRepository.save(mascota86);

        Mascota mascota87 = new Mascota(null, "Milo", "Chihuahua", 2, 3.2f, "Problemas de ansiedad",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente37);
        mascotaRepository.save(mascota87);

        Mascota mascota88 = new Mascota(null, "Ruby", "Dálmata", 3, 14.0f, "Problemas de audición",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente38);
        mascotaRepository.save(mascota88);

        Mascota mascota89 = new Mascota(null, "Oscar", "Boxer", 4, 18.5f, "Problemas cardíacos",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente39);
        mascotaRepository.save(mascota89);

        Mascota mascota90 = new Mascota(null, "Lucky", "Shiba Inu", 2, 8.0f, "Problemas de tiroides",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente40);
        mascotaRepository.save(mascota90);

        Mascota mascota91 = new Mascota(null, "Rex", "Bulldog", 3, 13.0f, "Problemas de piel",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente41);
        mascotaRepository.save(mascota91);

        Mascota mascota92 = new Mascota(null, "Sasha", "Pastor Belga", 4, 24.5f, "Displasia de cadera",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente42);
        mascotaRepository.save(mascota92);

        Mascota mascota93 = new Mascota(null, "Bruno", "Beagle", 2, 9.5f, "Problemas digestivos",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente43);
        mascotaRepository.save(mascota93);

        Mascota mascota94 = new Mascota(null, "Lola", "Golden Retriever", 5, 21.0f, "Cáncer",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente44);
        mascotaRepository.save(mascota94);

        Mascota mascota95 = new Mascota(null, "Thor", "Poodle", 1, 5.5f, "Problemas de tiroides",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente45);
        mascotaRepository.save(mascota95);

        Mascota mascota96 = new Mascota(null, "Mia", "Chihuahua", 2, 3.5f, "Problemas de conducta",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente46);
        mascotaRepository.save(mascota96);

        Mascota mascota97 = new Mascota(null, "Simba", "Dálmata", 3, 14.5f, "Problemas hepáticos",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente47);
        mascotaRepository.save(mascota97);

        Mascota mascota98 = new Mascota(null, "Nala", "Boxer", 4, 17.5f, "Problemas respiratorios",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente48);
        mascotaRepository.save(mascota98);

        Mascota mascota99 = new Mascota(null, "Roco", "Shiba Inu", 2, 7.5f, "Problemas de ansiedad",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente49);
        mascotaRepository.save(mascota99);

        Mascota mascota100 = new Mascota(null, "Luna", "Husky", 3, 16.0f, "Problemas de visión",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente50);
        mascotaRepository.save(mascota100);

        // Creación de 10 tratamientos
        List<Tratamiento> tratamientos = Arrays.asList(
        new Tratamiento(1, "TRAT001", new Date(), "Desparasitación interna", veterinario2, mascota1, servicioConsulta, null),
        new Tratamiento(2, "TRAT002", new Date(), "Control de pulgas y garrapatas", veterinario1, mascota2, servicioConsulta, null),
        new Tratamiento(3, "TRAT003", new Date(), "Tratamiento antiinflamatorio", veterinario5, mascota3, servicioConsulta, null),
        new Tratamiento(4, "TRAT004", new Date(), "Antibiótico para infecciones", veterinario4, mascota4, servicioConsulta, null),
        new Tratamiento(5, "TRAT005", new Date(), "Analgésico postoperatorio", veterinario1, mascota5, servicioConsulta, null),
        new Tratamiento(6, "TRAT006", new Date(), "Reducción de estrés", veterinario6, mascota6, servicioConsulta, null),
        new Tratamiento(7, "TRAT007", new Date(), "Cuidado renal", veterinario1, mascota7, servicioConsulta, null),
        new Tratamiento(8, "TRAT008", new Date(), "Tratamiento digestivo", veterinario6, mascota8, servicioConsulta, null),
        new Tratamiento(9, "TRAT009", new Date(), "Terapia para articulaciones", veterinario3, mascota9, servicioConsulta, null),
        new Tratamiento(10, "TRAT010", new Date(), "Tratamiento para infecciones urinarias", veterinario6, mascota10, servicioConsulta, null)
        );
        tratamientoRepository.saveAll(tratamientos);

        // Creación de medicamentos
        List<Medicamento> medicamentos = Arrays.asList(
        new Medicamento(null, "Advantix", 150.0f, 200.0f, 50, 10, null),
        new Medicamento(null, "Drontal", 100.0f, 130.0f, 60, 15, null),
        new Medicamento(null, "Vetoquinol", 80.0f, 110.0f, 40, 20, null),
        new Medicamento(null, "Cortaf", 75.0f, 100.0f, 45, 12, null),
        new Medicamento(null, "Milbemax", 120.0f, 150.0f, 70, 8, null),
        new Medicamento(null, "Metronidazol", 90.0f, 120.0f, 55, 16, null),
        new Medicamento(null, "Rimadyl", 200.0f, 250.0f, 30, 5, null),
        new Medicamento(null, "Panacur", 85.0f, 110.0f, 50, 18, null),
        new Medicamento(null, "Zylkene", 150.0f, 180.0f, 35, 6, null),
        new Medicamento(null, "Bexacat", 110.0f, 140.0f, 40, 7, null)
        );
        medicamentoRepository.saveAll(medicamentos);

        // Asociar tratamientos con múltiples medicamentos distintos
        List<TratamientoMedicamento> tratamientosMedicamentos = new ArrayList<>();
        Random random = new Random();

        for (Tratamiento tratamiento : tratamientos) {
        // Selecciona una cantidad aleatoria de medicamentos entre 1 y 3
        int cantidadMedicamentos = 1 + random.nextInt(3);

        // Crea una copia aleatoria del listado para evitar repetidos
        List<Medicamento> medicamentosAleatorios = new ArrayList<>(medicamentos);
        Collections.shuffle(medicamentosAleatorios);

        for (int j = 0; j < cantidadMedicamentos && j < medicamentosAleatorios.size(); j++) {
                Medicamento medicamento = medicamentosAleatorios.get(j);
                int cantidad = 1 + random.nextInt(3); // Entre 1 y 3 unidades

                TratamientoMedicamento tratamientoMedicamento = new TratamientoMedicamento(
                null, tratamiento, medicamento, cantidad
                );
                tratamientosMedicamentos.add(tratamientoMedicamento);
        }
        }

        // Guardar asociaciones en la base de datos
        tratamientoMedicamentoRepository.saveAll(tratamientosMedicamentos);

        // Creación de citas
        Cita cita1 = new Cita(null,
        new Date(System.currentTimeMillis() + 3600 * 1000),
        "Sucursal Norte",
        mascotaRepository.findById(1).orElse(null),
        veterinarioRepository.findById(1).orElse(null),
        servicioRepository.findById(1).orElse(null),
                "Agendada"
        );
        citaRepository.save(cita1);

        Cita cita2 = new Cita(null,
        new Date(System.currentTimeMillis() + 7200 * 1000),
        "Sucursal Centro",
        mascotaRepository.findById(2).orElse(null),
        veterinarioRepository.findById(2).orElse(null),
        servicioRepository.findById(2).orElse(null),
                "Agendada"
        );
        citaRepository.save(cita2);

        Cita cita3 = new Cita(null,
        new Date(System.currentTimeMillis() + 10800 * 1000),
        "Sucursal Sur",
        mascotaRepository.findById(3).orElse(null),
        veterinarioRepository.findById(1).orElse(null),
        servicioRepository.findById(3).orElse(null),
                "Agendada"
        );
        citaRepository.save(cita3);

        // Creación de testimonios
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2025, Calendar.FEBRUARY, 1);
        Date fecha1 = calendar1.getTime();

        Testimonio testimonio1 = new Testimonio(
            null,
            "Excelente atención, mi perrita quedó preciosa después del baño.",
            5,
            fecha1,
            clienteRepository.findById(1).orElse(null),
            servicioRepository.findById(3).orElse(null)
        );
        testimonioRepository.save(testimonio1);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2025, Calendar.MARCH, 15);
        Date fecha2 = calendar2.getTime();

        Testimonio testimonio2 = new Testimonio(
            null,
            "El veterinario fue muy profesional y resolvió todas mis dudas.",
            4,
            fecha2,
            clienteRepository.findById(2).orElse(null),
            servicioRepository.findById(1).orElse(null)
        );
        testimonioRepository.save(testimonio2);

        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2025, Calendar.APRIL, 10);
        Date fecha3 = calendar3.getTime();

        Testimonio testimonio3 = new Testimonio(
            null,
            "Muy agradecido por la atención durante la hospitalización de mi mascota.",
            5,
            fecha3,
            clienteRepository.findById(3).orElse(null),
            servicioRepository.findById(4).orElse(null)
        );
        testimonioRepository.save(testimonio3);

        System.out.println("Base de datos inicializada con datos de ejemplo.");
    }
}