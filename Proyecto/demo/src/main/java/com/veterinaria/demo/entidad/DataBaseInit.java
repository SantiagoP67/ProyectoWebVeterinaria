package com.veterinaria.demo.entidad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Collections;
import java.util.Random;
import java.text.SimpleDateFormat;

import com.veterinaria.demo.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import jakarta.transaction.Transactional;

@Controller
@Transactional
@Profile("default")
public class DataBaseInit implements ApplicationRunner {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private TestimonioRepository testimonioRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private TratamientoMedicamentoRepository tratamientoMedicamentoRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;



    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Creación de roles
        Role role1 = new Role("CLIENTE");
        roleRepository.save(role1);
        Role role2 = new Role("VETERINARIO");
        roleRepository.save(role2);
        Role role3 = new Role("ADMIN");
        roleRepository.save(role3);

        // Creación de clientes
        Cliente cliente1 = new Cliente(null, "Juan Pérez", "juan.perez@gmail.com", "3001234567",
                "https://www.mundopsicologos.com/site/article/49504/52397/las-personas-vitamina-0_ai1.jpg",
                "123456789", "juanp", "pass1", null,null, null,null);
        UserEntity userEntity = saveCliente(cliente1);
        cliente1.setUser(userEntity);
        clienteRepository.save(cliente1);

        Cliente cliente2 = new Cliente(null, "Carlos Gómez", "carlos.gomez@gmail.com", "3112345678",
                "https://www.donnamoderna.com/content/uploads/2022/07/Donna-sorridente-830x625.jpg",
                "987654321", "carlosg", "pass2",null, null, null,null);
        UserEntity userEntity2 = saveCliente(cliente2);
        cliente2.setUser(userEntity2);
        clienteRepository.save(cliente2);

        Cliente cliente3 = new Cliente(null, "Ana Martínez", "ana.martinez@gmail.com", "3223456789",
                "https://www.mundopsicologos.com/site/article/60606/50895/las-10-cualidades-de-una-persona-mas-valoradas-0_ai1.jpg",
                "456789123", "anam", "pass3",null, null, null,null);

        UserEntity userEntity3 = saveCliente(cliente3);
        cliente3.setUser(userEntity3);
        clienteRepository.save(cliente3);

        Cliente cliente4 = new Cliente(null, "Luis Rodríguez", "luis.rodriguez@gmail.com", "3009876543",
                "https://www.clarin.com/2023/12/28/k8gOUmfp5_720x0__1.jpg",
                "654321987", "luisr", "pass4",null, null, null,null);
        UserEntity userEntity4 = saveCliente(cliente4);
        cliente4.setUser(userEntity4);
        clienteRepository.save(cliente4);

        Cliente cliente5 = new Cliente(null, "María Fernanda López", "maria.lopez@gmail.com", "3205678901",
                "https://concepto.de/wp-content/uploads/2018/08/persona-e1533759204552.jpg",
                "741852963", "marial", "pass5", null,null, null,null);
        UserEntity userEntity5 = saveCliente(cliente5);
        cliente5.setUser(userEntity5);
        clienteRepository.save(cliente5);

        Cliente cliente6 = new Cliente(null, "Pedro Sánchez", "pedro.sanchez@gmail.com", "3216789012",
                "https://www.clarin.com/2023/12/01/rhVeUAooY_2000x1500__1.jpg",
                "369258147", "pedros", "pass6", null,null, null,null);
        UserEntity userEntity6 = saveCliente(cliente6);
        cliente6.setUser(userEntity6);
        clienteRepository.save(cliente6);

        Cliente cliente7 = new Cliente(null, "Laura Torres", "laura.torres@gmail.com", "3127890123",
                "https://aishlatino.b-cdn.net/wp-content/uploads/2021/11/que-tipo-de-persona-te-gustaria-ser-730x411-SP.jpg",
                "852741963", "laurat", "pass7", null,null, null,null);
        UserEntity userEntity7 = saveCliente(cliente7);
        cliente7.setUser(userEntity7);
        clienteRepository.save(cliente7);

        Cliente cliente8 = new Cliente(null, "Ricardo Mendoza", "ricardo.mendoza@gmail.com", "3138901234",
                "https://www.wellme.es/site/article/60493/50775/como-ser-mejor-persona-6-metodos-para-ser-la-mejor-version-de-ti-mismoa-0_ai1.jpg",
                "147963852", "ricardom", "pass8", null,null, null,null);
        UserEntity userEntity8 = saveCliente(cliente8);
        cliente8.setUser(userEntity8);
        clienteRepository.save(cliente8);

        Cliente cliente9 = new Cliente(null, "Sofía Ramírez", "sofia.ramirez@gmail.com", "3149012345",
                "https://img.freepik.com/free-psd/portrait-man-teenager-isolated_23-2151745771.jpg",
                "258147369", "sofiar", "pass9", null,null, null,null);
        UserEntity userEntity9 = saveCliente(cliente9);
        cliente9.setUser(userEntity9);
        clienteRepository.save(cliente9);

        Cliente cliente10 = new Cliente(null, "Fernando Castillo", "fernando.castillo@gmail.com", "3150123456",
                "https://centrointegraldepsicologia.com/wp-content/uploads/2023/06/El-Sindrome-de-la-Buena-Persona-Los-Limites-Olvidados-1024x576.png",
                "369852741", "fernandoc", "pass10", null,null, null,null);
        UserEntity userEntity10 = saveCliente(cliente10);
        cliente10.setUser(userEntity10);
        clienteRepository.save(cliente10);

        Cliente cliente11 = new Cliente(null, "Carmen Gutiérrez", "carmen.gutierrez@gmail.com", "3161234567",
                "https://media.diariouno.com.ar/p/76d6d1fd697f673cf18184008b6b2d09/adjuntos/298/imagenes/009/371/0009371021/1200x0/smart/psicologia-10-claves-buen-personajpg.jpg",
                "741369852", "carmeng", "pass11", null,null, null,null);
        UserEntity userEntity11 = saveCliente(cliente11);
        cliente11.setUser(userEntity11);
        clienteRepository.save(cliente11);

        Cliente cliente12 = new Cliente(null, "Javier Herrera", "javier.herrera@gmail.com", "3172345678",
                "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg",
                "852369147", "javierh", "pass12", null,null, null,null);
        UserEntity userEntity12 = saveCliente(cliente12);
        cliente12.setUser(userEntity12);
        clienteRepository.save(cliente12);

        Cliente cliente13 = new Cliente(null, "Elena Vargas", "elena.vargas@gmail.com", "3183456789",
                "https://imagenes.eltiempo.com/files/image_1200_535/files/fp/uploads/2024/03/19/65f9d492598ea.r_d.1079-279-5658.jpeg",
                "963741852", "elenav", "pass13", null,null, null,null);
        UserEntity userEntity13 = saveCliente(cliente13);
        cliente13.setUser(userEntity13);
        clienteRepository.save(cliente13);

        Cliente cliente14 = new Cliente(null, "Raúl Morales", "raul.morales@gmail.com", "3194567890",
                "https://www.portafolio.co/files/article_new_multimedia/uploads/2024/02/06/65c27d24da9df.jpeg",
                "147852963", "raulm", "pass14", null,null, null,null);
        UserEntity userEntity14 = saveCliente(cliente14);
        cliente14.setUser(userEntity14);
        clienteRepository.save(cliente14);

        Cliente cliente15 = new Cliente(null, "Andrea Suárez", "andrea.suarez@gmail.com", "3205678901",
                "https://www.mundopsicologos.com/site/article/49504/52397/las-personas-vitamina-0_ai1.jpg",
                "258963741", "andreas", "pass15", null,null, null,null);
        UserEntity userEntity15 = saveCliente(cliente15);
        cliente15.setUser(userEntity15);
        clienteRepository.save(cliente15);

        Cliente cliente16 = new Cliente(null, "Diego Paredes", "diego.paredes@gmail.com", "3216789012",
                "https://concepto.de/wp-content/uploads/2018/08/persona-e1533759204552.jpg",
                "369741852", "diegop", "pass16",null, null, null,null);
        UserEntity userEntity16 = saveCliente(cliente16);
        cliente16.setUser(userEntity16);
        clienteRepository.save(cliente16);

        Cliente cliente17 = new Cliente(null, "Paula Ríos", "paula.rios@gmail.com", "3227890123",
                "https://www.mundopsicologos.com/site/article/60606/50895/las-10-cualidades-de-una-persona-mas-valoradas-0_ai1.jpg",
                "741258963", "paular", "pass17",null, null, null,null);
        UserEntity userEntity17 = saveCliente(cliente17);
        cliente17.setUser(userEntity17);
        clienteRepository.save(cliente17);

        Cliente cliente18 = new Cliente(null, "Hugo Benítez", "hugo.benitez@gmail.com", "3238901234",
                "https://www.clarin.com/2023/12/28/k8gOUmfp5_720x0__1.jpg",
                "852369741", "hugob", "pass18",null, null, null,null);
        UserEntity userEntity18 = saveCliente(cliente18);
        cliente18.setUser(userEntity18);
        clienteRepository.save(cliente18);

        Cliente cliente19 = new Cliente(null, "Diana Salazar", "diana.salazar@gmail.com", "3249012345",
                "https://concepto.de/wp-content/uploads/2018/08/persona-e1533759204552.jpg",
                "963147852", "dianas", "pass19", null,null, null,null);
        UserEntity userEntity19 = saveCliente(cliente19);
        cliente19.setUser(userEntity19);
        clienteRepository.save(cliente19);

        Cliente cliente20 = new Cliente(null, "Gabriel Flores", "gabriel.flores@gmail.com", "3250123456",
                "https://www.clarin.com/2023/12/01/rhVeUAooY_2000x1500__1.jpg",
                "147963258", "gabrielf", "pass20", null,null, null,null);
        UserEntity userEntity20 = saveCliente(cliente20);
        cliente20.setUser(userEntity20);
        clienteRepository.save(cliente20);

        Cliente cliente21 = new Cliente(null, "Verónica Méndez", "veronica.mendez@gmail.com", "3261234567",
                "https://aishlatino.b-cdn.net/wp-content/uploads/2021/11/que-tipo-de-persona-te-gustaria-ser-730x411-SP.jpg",
                "258741369", "veronicam", "pass21", null,null, null,null);
        UserEntity userEntity21 = saveCliente(cliente21);
        cliente21.setUser(userEntity21);
        clienteRepository.save(cliente21);

        Cliente cliente22 = new Cliente(null, "Francisco Cortés", "francisco.cortes@gmail.com", "3272345678",
                "https://www.wellme.es/site/article/60493/50775/como-ser-mejor-persona-6-metodos-para-ser-la-mejor-version-de-ti-mismoa-0_ai1.jpg",
                "369852147", "franciscoc", "pass22", null,null, null,null);
        UserEntity userEntity22 = saveCliente(cliente22);
        cliente22.setUser(userEntity22);
        clienteRepository.save(cliente22);

        Cliente cliente23 = new Cliente(null, "Julia Ocampo", "julia.ocampo@gmail.com", "3283456789",
                "https://img.freepik.com/free-psd/portrait-man-teenager-isolated_23-2151745771.jpg",
                "741369258", "juliao", "pass23", null,null, null,null);
        UserEntity userEntity23 = saveCliente(cliente23);
        cliente23.setUser(userEntity23);
        clienteRepository.save(cliente23);

        Cliente cliente24 = new Cliente(null, "Óscar Naranjo", "oscar.naranjo@gmail.com", "3294567890",
                "https://img.freepik.com/fotos-premium/retrato-hombre-joven-guapo_53876-38137.jpg?semt=ais_hybrid",
                "852741369", "oscarn", "pass24", null,null, null,null);
        UserEntity userEntity24 = saveCliente(cliente24);
        cliente24.setUser(userEntity24);
        clienteRepository.save(cliente24);

        Cliente cliente25 = new Cliente(null, "Mónica León", "monica.leon@gmail.com", "3305678901",
                "https://media.diariouno.com.ar/p/76d6d1fd697f673cf18184008b6b2d09/adjuntos/298/imagenes/009/371/0009371021/1200x0/smart/psicologia-10-claves-buen-personajpg.jpg",
                "963852741", "monical", "pass25", null,null, null,null);
        UserEntity userEntity25 = saveCliente(cliente25);
        cliente25.setUser(userEntity25);
        clienteRepository.save(cliente25);

        Cliente cliente26 = new Cliente(null, "Renato Villalba", "renato.villalba@gmail.com", "3316789012",
                "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg",
                "100001", "renatov", "pass26", null,null, null,null);
        UserEntity userEntity26 = saveCliente(cliente26);
        cliente26.setUser(userEntity26);
        clienteRepository.save(cliente26);

        Cliente cliente27 = new Cliente(null, "Lucía Méndez", "lucia.mendez@gmail.com", "3327890123",
                "https://imagenes.eltiempo.com/files/image_1200_535/files/fp/uploads/2024/03/19/65f9d492598ea.r_d.1079-279-5658.jpeg",
                "100002", "luciam", "pass27", null,null, null,null);
        UserEntity userEntity27 = saveCliente(cliente27);
        cliente27.setUser(userEntity27);
        clienteRepository.save(cliente27);

        Cliente cliente28 = new Cliente(null, "Emilio Vargas", "emilio.vargas@gmail.com", "3338901234",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6TxYHqrtHNmxOgeapPvtw6i9EkKaQ-khhRQ&s",
                "100003", "emiliov", "pass28", null,null, null,null);
        UserEntity userEntity28 = saveCliente(cliente28);
        cliente28.setUser(userEntity28);
        clienteRepository.save(cliente28);

        Cliente cliente29 = new Cliente(null, "Natalia Ortega", "natalia.ortega@gmail.com", "3349012345",
                "https://www.mundopsicologos.com/site/article/49504/52397/las-personas-vitamina-0_ai1.jpg",
                "100004", "nataliao", "pass29", null,null, null,null);
        UserEntity userEntity29 = saveCliente(cliente29);
        cliente29.setUser(userEntity29);
        clienteRepository.save(cliente29);

        Cliente cliente30 = new Cliente(null, "Rodrigo Peña", "rodrigo.pena@gmail.com", "3350123456",
                "https://www.donnamoderna.com/content/uploads/2022/07/Donna-sorridente-830x625.jpg",
                "100005", "rodrigop", "pass30", null,null, null,null);
        UserEntity userEntity30 = saveCliente(cliente30);
        cliente30.setUser(userEntity30);
        clienteRepository.save(cliente30);

        Cliente cliente31 = new Cliente(null, "Valeria Salinas", "valeria.salinas@gmail.com", "3361234567",
                "https://www.mundopsicologos.com/site/article/60606/50895/las-10-cualidades-de-una-persona-mas-valoradas-0_ai1.jpg",
                "100006", "valerias", "pass31", null,null, null,null);
        UserEntity userEntity31 = saveCliente(cliente31);
        cliente31.setUser(userEntity31);
        clienteRepository.save(cliente31);

        Cliente cliente32 = new Cliente(null, "Esteban Rojas", "esteban.rojas@gmail.com", "3372345678",
                "https://www.clarin.com/2023/12/28/k8gOUmfp5_720x0__1.jpg",
                "100007", "estebanr", "pass32", null,null, null,null);
        UserEntity userEntity32 = saveCliente(cliente32);
        cliente32.setUser(userEntity32);
        clienteRepository.save(cliente32);

        Cliente cliente33 = new Cliente(null, "Isabela Herrera", "isabela.herrera@gmail.com", "3383456789",
                "https://concepto.de/wp-content/uploads/2018/08/persona-e1533759204552.jpg",
                "100008", "isabelah", "pass33", null,null, null,null);
        UserEntity userEntity33 = saveCliente(cliente33);
        cliente33.setUser(userEntity33);
        clienteRepository.save(cliente33);

        Cliente cliente34 = new Cliente(null, "Andrés Molina", "andres.molina@gmail.com", "3394567890",
                "https://www.clarin.com/2023/12/01/rhVeUAooY_2000x1500__1.jpg",
                "100009", "andresm", "pass34", null,null, null,null);
        UserEntity userEntity34 = saveCliente(cliente34);
        cliente34.setUser(userEntity34);
        clienteRepository.save(cliente34);

        Cliente cliente35 = new Cliente(null, "Camila Fernández", "camila.fernandez@gmail.com", "3405678901",
                "https://aishlatino.b-cdn.net/wp-content/uploads/2021/11/que-tipo-de-persona-te-gustaria-ser-730x411-SP.jpg",
                "100010", "camilaf", "pass35", null,null, null,null);
        UserEntity userEntity35 = saveCliente(cliente35);
        cliente35.setUser(userEntity35);
        clienteRepository.save(cliente35);

        Cliente cliente36 = new Cliente(null, "Diego Castro", "diego.castro@gmail.com", "3416789012",
                "https://www.wellme.es/site/article/60493/50775/como-ser-mejor-persona-6-metodos-para-ser-la-mejor-version-de-ti-mismoa-0_ai1.jpg",
                "100011", "diegoc", "pass36",null, null, null,null);
        UserEntity userEntity36 = saveCliente(cliente36);
        cliente36.setUser(userEntity36);
        clienteRepository.save(cliente36);

        Cliente cliente37 = new Cliente(null, "Santiago Ramos", "santiago.ramos@gmail.com", "3427890123",
                "https://img.freepik.com/free-psd/portrait-man-teenager-isolated_23-2151745771.jpg",
                "100012", "santiagor", "pass37", null,null, null,null);
        UserEntity userEntity37 = saveCliente(cliente37);
        cliente37.setUser(userEntity37);
        clienteRepository.save(cliente37);

        Cliente cliente38 = new Cliente(null, "Gabriela Ríos", "gabriela.rios@gmail.com", "3438901234",
                "https://centrointegraldepsicologia.com/wp-content/uploads/2023/06/El-Sindrome-de-la-Buena-Persona-Los-Limites-Olvidados-1024x576.png",
                "100013", "gabrielar", "pass38", null,null, null,null);
        UserEntity userEntity38 = saveCliente(cliente38);
        cliente38.setUser(userEntity38);
        clienteRepository.save(cliente38);

        Cliente cliente39 = new Cliente(null, "Fernando Ocampo", "fernando.ocampo@gmail.com", "3449012345",
                "https://media.diariouno.com.ar/p/76d6d1fd697f673cf18184008b6b2d09/adjuntos/298/imagenes/009/371/0009371021/1200x0/smart/psicologia-10-claves-buen-personajpg.jpg",
                "100014", "fernandoo", "pass39", null,null, null,null);
        UserEntity userEntity39 = saveCliente(cliente39);
        cliente39.setUser(userEntity39);
        clienteRepository.save(cliente39);

        Cliente cliente40 = new Cliente(null, "Paola González", "paola.gonzalez@gmail.com", "3450123456",
                "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg",
                "100015", "paolag", "pass40", null,null, null,null);
        UserEntity userEntity40 = saveCliente(cliente40);
        cliente40.setUser(userEntity40);
        clienteRepository.save(cliente40);

        Cliente cliente41 = new Cliente(null, "Ricardo Estrada", "ricardo.estrada@gmail.com", "3461234567",
                "https://imagenes.eltiempo.com/files/image_1200_535/files/fp/uploads/2024/03/19/65f9d492598ea.r_d.1079-279-5658.jpeg",
                "100016", "ricardoe", "pass41", null,null, null,null);
        UserEntity userEntity41 = saveCliente(cliente41);
        cliente41.setUser(userEntity41);
        clienteRepository.save(cliente41);

        Cliente cliente42 = new Cliente(null, "Alejandra Campos", "alejandra.campos@gmail.com", "3472345678",
                "https://www.portafolio.co/files/article_new_multimedia/uploads/2024/02/06/65c27d24da9df.jpeg",
                "100017", "alejandrac", "pass42", null,null, null,null);
        UserEntity userEntity42 = saveCliente(cliente42);
        cliente42.setUser(userEntity42);
        clienteRepository.save(cliente42);

        Cliente cliente43 = new Cliente(null, "Manuel Ortega", "manuel.ortega@gmail.com", "3483456789",
                "https://www.mundopsicologos.com/site/article/49504/52397/las-personas-vitamina-0_ai1.jpg",
                "100018", "manuelo", "pass43",null, null, null,null);
        UserEntity userEntity43 = saveCliente(cliente43);
        cliente43.setUser(userEntity43);
        clienteRepository.save(cliente43);

        Cliente cliente44 = new Cliente(null, "Beatriz Montes", "beatriz.montes@gmail.com", "3494567890",
                "https://www.donnamoderna.com/content/uploads/2022/07/Donna-sorridente-830x625.jpg",
                "100019", "beatrizm", "pass44",null, null, null,null);
        UserEntity userEntity44 = saveCliente(cliente44);
        cliente44.setUser(userEntity44);
        clienteRepository.save(cliente44);

        Cliente cliente45 = new Cliente(null, "Joaquín Pacheco", "joaquin.pacheco@gmail.com", "3505678901",
                "https://www.mundopsicologos.com/site/article/60606/50895/las-10-cualidades-de-una-persona-mas-valoradas-0_ai1.jpg",
                "100020", "joaquinp", "pass45", null,null, null,null);
        UserEntity userEntity45 = saveCliente(cliente45);
        cliente45.setUser(userEntity45);
        clienteRepository.save(cliente45);

        Cliente cliente46 = new Cliente(null, "Lorena Navarro", "lorena.navarro@gmail.com", "3516789012",
                "https://www.clarin.com/2023/12/28/k8gOUmfp5_720x0__1.jpg",
                "100021", "lorenan", "pass46", null,null, null,null);
        UserEntity userEntity46 = saveCliente(cliente46);
        cliente46.setUser(userEntity46);
        clienteRepository.save(cliente46);

        Cliente cliente47 = new Cliente(null, "Cristian Mendoza", "cristian.mendoza@gmail.com", "3527890123",
                "https://concepto.de/wp-content/uploads/2018/08/persona-e1533759204552.jpg",
                "100022", "cristianm", "pass47", null,null, null,null);
        UserEntity userEntity47 = saveCliente(cliente47);
        cliente47.setUser(userEntity47);
        clienteRepository.save(cliente47);

        Cliente cliente48 = new Cliente(null, "Patricia Vargas", "patricia.vargas@gmail.com", "3538901234",
                "https://www.clarin.com/2023/12/01/rhVeUAooY_2000x1500__1.jpg",
                "100023", "patriciav", "pass48", null,null, null,null);
        UserEntity userEntity48 = saveCliente(cliente48);
        cliente48.setUser(userEntity48);
        clienteRepository.save(cliente48);

        Cliente cliente49 = new Cliente(null, "Fabián Delgado", "fabian.delgado@gmail.com", "3549012345",
                "https://aishlatino.b-cdn.net/wp-content/uploads/2021/11/que-tipo-de-persona-te-gustaria-ser-730x411-SP.jpg",
                "100024", "fabiand", "pass49",null, null, null,null);
        UserEntity userEntity49 = saveCliente(cliente49);
        cliente49.setUser(userEntity49);
        clienteRepository.save(cliente49);

        Cliente cliente50 = new Cliente(null, "Mariana Bustos", "mariana.bustos@gmail.com", "3550123456",
                "https://www.wellme.es/site/article/60493/50775/como-ser-mejor-persona-6-metodos-para-ser-la-mejor-version-de-ti-mismoa-0_ai1.jpg",
                "100025", "marianab", "pass50", null,null, null,null);
        UserEntity userEntity50 = saveCliente(cliente50);
        cliente50.setUser(userEntity50);
        clienteRepository.save(cliente50);

        // Creación de veterinarios con patrón Builder
        Veterinario veterinario1 = Veterinario.builder()
                .idVeterinario(null)
                .nombre("Dra. Martínez")
                .cedula("654321")
                .especialidad("Especialista en Cirugía")
                .foto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDcaEWpYQklMDUzSJPss_l5V9T7yC2xtK7OA&s")
                .sede("Los Pinos")
                .estado(1)
                .numeroAtenciones(12)
                .nombreUsuario("vet1")
                .contrasena("pass1")
                .citas(null)
                .tratamientos(null)
                .build();
        UserEntity userEntityVet1 = saveVeterinario(veterinario1);
        veterinario1.setUser(userEntityVet1);
        veterinarioRepository.save(veterinario1);

        Veterinario veterinario2 = Veterinario.builder()
                .idVeterinario(null)
                .nombre("Dr. Gómez")
                .cedula("789012")
                .especialidad("Dermatología Veterinaria")
                .foto("https://images.freeimages.com/images/premium/previews/1916/19167116-male-vet-in-lab-coat-with-cat.jpg")
                .sede("Los Pinos")
                .estado(1)
                .numeroAtenciones(8)
                .nombreUsuario("vet2")
                .contrasena("pass2")
                .citas(null)
                .tratamientos(null)
                .build();
        UserEntity userEntityVet2 = saveVeterinario(veterinario2);
        veterinario2.setUser(userEntityVet2);
        veterinarioRepository.save(veterinario2);

        Veterinario veterinario3 = Veterinario.builder()
                .idVeterinario(null)
                .nombre("Dra. Fernández")
                .cedula("345678")
                .especialidad("Cardiología Veterinaria")
                .foto("https://media.istockphoto.com/id/1995860815/es/foto/mujer-veterinaria-sosteniendo-al-perro-jack-russell.jpg?s=612x612&w=0&k=20&c=ZLFwLWVnPXnCx876vI312OhVUUOEU5Z_9ZHQfvBS4jk=")
                .sede("Los Pinos")
                .estado(0)
                .numeroAtenciones(15)
                .nombreUsuario("vet3")
                .contrasena("pass3")
                .citas(null)
                .tratamientos(null)
                .build();
        UserEntity userEntityVet3 = saveVeterinario(veterinario3);
        veterinario3.setUser(userEntityVet3);
        veterinarioRepository.save(veterinario3);

        Veterinario veterinario4 = Veterinario.builder()
                .idVeterinario(null)
                .nombre("Dr. Rodríguez")
                .cedula("901234")
                .especialidad("Neurología Veterinaria")
                .foto("https://www.shutterstock.com/image-photo/senior-greyhaired-man-wearing-veterinarian-260nw-2163179989.jpg")
                .sede("Patitas Felices")
                .estado(1)
                .numeroAtenciones(20)
                .nombreUsuario("vet4")
                .contrasena("pass4")
                .citas(null)
                .tratamientos(null)
                .build();
        UserEntity userEntityVet4 = saveVeterinario(veterinario4);
        veterinario4.setUser(userEntityVet4);
        veterinarioRepository.save(veterinario4);

        Veterinario veterinario5 = Veterinario.builder()
                .idVeterinario(null)
                .nombre("Dra. López")
                .cedula("567890")
                .especialidad("Especialista en Animales Exóticos")
                .foto("https://i0.wp.com/blog.leasemd.mx/wp-content/uploads/2023/10/Leasing-Equipos-Veterinarios-Mexico.png?fit=800%2C533&ssl=1")
                .sede("Patitas Felices")
                .estado(0)
                .numeroAtenciones(18)
                .nombreUsuario("vet5")
                .contrasena("pass5")
                .citas(null)
                .tratamientos(null)
                .build();
        UserEntity userEntityVet5 = saveVeterinario(veterinario5);
        veterinario5.setUser(userEntityVet5);
        veterinarioRepository.save(veterinario5);

        Veterinario veterinario6 = Veterinario.builder()
                .idVeterinario(null)
                .nombre("Dr. Ramírez")
                .cedula("678901")
                .especialidad("Cirujano Veterinario")
                .foto("https://www.diarioveterinario.com/images/showid2/2860071?w=900&mh=700")
                .sede("Patitas Felices")
                .estado(1)
                .numeroAtenciones(15)
                .nombreUsuario("vet6")
                .contrasena("pass6")
                .citas(null)
                .tratamientos(null)
                .build();
        UserEntity userEntityVet6 = saveVeterinario(veterinario6);
        veterinario6.setUser(userEntityVet6);
        veterinarioRepository.save(veterinario6);

        Veterinario veterinario7 = Veterinario.builder()
                .idVeterinario(null)
                .nombre("Dra. Fernández")
                .cedula("789012")
                .especialidad("Especialista en Animales de Granja")
                .foto("https://sumimascotas.com/wp-content/uploads/2023/05/9.Dia-del-Veterinario-Colombia-1.jpg")
                .sede("Huellas")
                .estado(0)
                .numeroAtenciones(20)
                .nombreUsuario("vet7")
                .contrasena("pass7")
                .citas(null)
                .tratamientos(null)
                .build();
        UserEntity userEntityVet7 = saveVeterinario(veterinario7);
        veterinario7.setUser(userEntityVet7);
        veterinarioRepository.save(veterinario7);

        Veterinario veterinario8 = Veterinario.builder()
                .idVeterinario(null)
                .nombre("Dr. Morales")
                .cedula("890123")
                .especialidad("Dermatólogo Veterinario")
                .foto("https://blog.agrovetmarket.com/wp-content/uploads/2020/05/vet.jpg")
                .sede("Huellas")
                .estado(1)
                .numeroAtenciones(12)
                .nombreUsuario("vet8")
                .contrasena("pass8")
                .citas(null)
                .tratamientos(null)
                .build();
        UserEntity userEntityVet8 = saveVeterinario(veterinario8);
        veterinario8.setUser(userEntityVet8);
        veterinarioRepository.save(veterinario8);

        Veterinario veterinario9 = Veterinario.builder()
                .idVeterinario(null)
                .nombre("Dra. Castillo")
                .cedula("901234")
                .especialidad("Especialista en Rehabilitación Animal")
                .foto("https://cdn0.expertoanimal.com/es/posts/3/6/3/cuando_llevar_a_mi_cachorro_al_veterinario_por_primera_vez_23363_600_square.jpg")
                .sede("Huellas")
                .estado(0)
                .numeroAtenciones(10)
                .nombreUsuario("vet9")
                .contrasena("pass9")
                .citas(null)
                .tratamientos(null)
                .build();
        UserEntity userEntityVet9 = saveVeterinario(veterinario9);
        veterinario9.setUser(userEntityVet9);
        veterinarioRepository.save(veterinario9);

        Veterinario veterinario10 = Veterinario.builder()
                .idVeterinario(null)
                .nombre("Dr. Pérez")
                .cedula("012345")
                .especialidad("Especialista en Cirugía")
                .foto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSN6GFsKiPWtTdAKZyKXFQj1P8L7BZkX2ziLb1thmXaYtGlJlJirPSlaG8bKB6i7hRrLJY&usqp=CAU")
                .sede("Huellas")
                .estado(1)
                .numeroAtenciones(8)
                .nombreUsuario("vet10")
                .contrasena("pass10")
                .citas(null)
                .tratamientos(null)
                .build();
        UserEntity userEntityVet10 = saveVeterinario(veterinario10);
        veterinario10.setUser(userEntityVet10);
        veterinarioRepository.save(veterinario10);


        // Creación de administrador
        Administrador administrador = new Administrador(null, "Carlos López", "carlosl@gmail.com",
                "https://portal.unbosque.edu.co/sites/default/files/inline-images/en-que-puede-trabajar-un-administrador-de-empresas.jpg",
                "987654321", "admin", "123", null);
        UserEntity userAdmin = saveAdministrador(administrador);
        administrador.setUser(userAdmin);
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

        /* Creación de métodos de pago
        MetodoPago metodoPago = new MetodoPago(null, "Tarjeta de Crédito", null);
        metodoPagoRepository.save(metodoPago);

        MetodoPago metodoPago2 = new MetodoPago(null, "Tarjeta de Débito", null);
        metodoPagoRepository.save(metodoPago2);

        MetodoPago metodoPago3 = new MetodoPago(null, "PSE", null);
        metodoPagoRepository.save(metodoPago3);

        MetodoPago metodoPago4 = new MetodoPago(null, "Efectivo", null);
        metodoPagoRepository.save(metodoPago4);

        MetodoPago metodoPago5 = new MetodoPago(null, "Transferencia bancaria", null);
        metodoPagoRepository.save(metodoPago5);*/

        // Creación de mascotas
        Mascota mascota1 = new Mascota(null, "Firulais", "Labrador", 3, 20.5f, "Otitis",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 0, cliente2, null);
        mascotaRepository.save(mascota1);

        Mascota mascota2 = new Mascota(null, "Max", "Bulldog", 2, 15.0f, "Problemas respiratorios",
                "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/fotolia_58776564-768x491.jpg", new Date(), new Date(), null, 1,
                cliente2, null);
        mascotaRepository.save(mascota2);

        Mascota mascota3 = new Mascota(null, "Luna", "Beagle", 4, 12.3f, "Alergia alimentaria",
                "https://media.istockphoto.com/id/1411469044/es/foto/beagle-perro-marr%C3%B3n-sentado-en-el-camino-en-la-ubicaci%C3%B3n-del-parque-natural-de-oto%C3%B1o-entre.jpg?s=612x612&w=0&k=20&c=eS96wdysCc3yDbkSAWbU-VFFWVxZiJ3O-MuFtCkIqPw=",
                new Date(), new Date(), null, 0, cliente2,null);
        mascotaRepository.save(mascota3);

        Mascota mascota4 = new Mascota(null, "Rocky", "Golden Retriever", 5, 25.0f, "Displasia de cadera",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente2,null);
        mascotaRepository.save(mascota4);

        Mascota mascota5 = new Mascota(null, "Bella", "Poodle", 2, 8.5f, "Problemas dentales",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 0, cliente2,null);
        mascotaRepository.save(mascota5);

        Mascota mascota6 = new Mascota(null, "Toby", "Chihuahua", 1, 3.0f, "Hipoglucemia",
                "https://media.istockphoto.com/id/1313232209/es/foto/chihuahua-marr%C3%B3n-sentado-en-el-suelo-perro-peque%C3%B1o-en-casa-asi%C3%A1tica-sentirse-feliz-y-relajarse.jpg?s=612x612&w=0&k=20&c=O8Ip4kGzyVBI9_BAzxLbbLy908-SUVwob_G8yt-LCl0=", new Date(), new Date(), null, 0,
                cliente2,null);
        mascotaRepository.save(mascota6);

        Mascota mascota7 = new Mascota(null, "Daisy", "Dálmata", 3, 18.0f, "Sordera congénita",
                "https://www.zaunk.com/wp-content/uploads/2020/05/dalmata-caracteristicas-scaled.jpg",
                new Date(), new Date(), null, 1, cliente7,null);
        mascotaRepository.save(mascota7);

        Mascota mascota8 = new Mascota(null, "Charlie", "Boxer", 4, 22.0f, "Cardiopatía",
                "https://media.istockphoto.com/id/1489772212/es/foto/perro-boxer.jpg?s=612x612&w=0&k=20&c=VbmTObu_ymhKolxjiOfirLEnV3uvYwlnJurA8GzLWbA=", new Date(), new Date(),
                null, 1, cliente8,null);
        mascotaRepository.save(mascota8);

        Mascota mascota9 = new Mascota(null, "Molly", "Shiba Inu", 2, 10.0f, "Dermatitis",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente21,null);
        mascotaRepository.save(mascota9);

        Mascota mascota10 = new Mascota(null, "Buddy", "Husky", 3, 19.5f, "Hipotiroidismo",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente10,null);
        mascotaRepository.save(mascota10);

        Mascota mascota11 = new Mascota(null, "Lola", "Bulldog Francés", 2, 12.0f, "Problemas oculares",
                "https://blog.agrocampo.com.co/wp-content/uploads/2021/11/perro-bulldog-ingles.jpg",
                new Date(), new Date(), null, 0, cliente11,null);
        mascotaRepository.save(mascota11);

        Mascota mascota12 = new Mascota(null, "Zeus", "Pastor Alemán", 4, 28.0f, "Displasia de codo",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente12,null);
        mascotaRepository.save(mascota12);

        Mascota mascota13 = new Mascota(null, "Coco", "Labrador", 3, 20.5f, "Obesidad",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente13,null);
        mascotaRepository.save(mascota13);

        Mascota mascota14 = new Mascota(null, "Milo", "Beagle", 2, 11.0f, "Epilepsia",
                "https://images.unsplash.com/photo-1572566830488-069bcc7fbcec?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fGJlYWdsZXxlbnwwfHwwfHx8MA%3D%3D", new Date(), new Date(), null, 1,
                cliente14,null);
        mascotaRepository.save(mascota14);

        Mascota mascota15 = new Mascota(null, "Ruby", "Golden Retriever", 5, 24.0f, "Artritis",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente15,null);
        mascotaRepository.save(mascota15);

        Mascota mascota16 = new Mascota(null, "Oscar", "Poodle", 1, 7.0f, "Problemas renales",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente16,null);
        mascotaRepository.save(mascota16);

        Mascota mascota17 = new Mascota(null, "Lucky", "Chihuahua", 2, 4.0f, "Luxación de rótula",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS43MdemPUJFdMPI7qQ-migHdyTOLuB8XUyXJfy34uvVT3Go5SwBMq1_Z6F4gqrJX75i9o&usqp=CAU",
                new Date(), new Date(), null, 1, cliente17,null);
        mascotaRepository.save(mascota17);

        Mascota mascota18 = new Mascota(null, "Rex", "Dálmata", 3, 17.0f, "Cálculos urinarios",
                "https://www.patasencasa.com/sites/default/files/styles/article_detail_1200/public/2024-07/perro%20d%C3%A1lmata_0.jpg.webp?itok=SO8y85Ya", new Date(), new Date(), null, 1,
                cliente18,null);
        mascotaRepository.save(mascota18);

        Mascota mascota19 = new Mascota(null, "Sasha", "Boxer", 4, 21.0f, "Problemas cardíacos",
                "https://www.nylabone.com/-/media/project/oneweb/nylabone/images/dog101/breeds-a-z/boxer.jpg",
                new Date(), new Date(), null, 1, cliente19,null);
        mascotaRepository.save(mascota19);

        Mascota mascota20 = new Mascota(null, "Bruno", "Shiba Inu", 2, 9.5f, "Alergia al polen",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente20,null);
        mascotaRepository.save(mascota20);

        Mascota mascota21 = new Mascota(null, "Lola", "Bulldog", 3, 14.0f, "Problemas de piel",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente21,null);
        mascotaRepository.save(mascota21);

        Mascota mascota22 = new Mascota(null, "Thor", "Pastor Belga", 4, 26.0f, "Displasia de cadera",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente22,null);
        mascotaRepository.save(mascota22);

        Mascota mascota23 = new Mascota(null, "Mia", "Beagle", 2, 10.5f, "Problemas digestivos",
                "https://images.unsplash.com/photo-1606833695155-e3498374e701?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE1fHx8ZW58MHx8fHx8",
                new Date(), new Date(), null, 1, cliente23,null);
        mascotaRepository.save(mascota23);

        Mascota mascota24 = new Mascota(null, "Simba", "Golden Retriever", 5, 23.0f, "Cáncer",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente24,null);
        mascotaRepository.save(mascota24);

        Mascota mascota25 = new Mascota(null, "Nala", "Poodle", 1, 6.5f, "Problemas de tiroides",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente25,null);
        mascotaRepository.save(mascota25);

        Mascota mascota26 = new Mascota(null, "Roco", "Chihuahua", 2, 3.5f, "Problemas de conducta",
                "https://img.freepik.com/foto-gratis/adorable-perro-chihuahua-afuera-hierba_23-2149880115.jpg?semt=ais_hybrid&w=740", new Date(), new Date(), null, 1,
                cliente26,null);
        mascotaRepository.save(mascota26);

        Mascota mascota27 = new Mascota(null, "Luna", "Dálmata", 3, 16.0f, "Problemas hepáticos",
                "https://www.patasencasa.com/sites/default/files/styles/article_detail_desktop/public/inline-images/dalmatian_dog_head_pet_canine_breed_animal_mammal-1087071.jpg.webp?itok=712uE4eM",
                new Date(), new Date(), null, 1, cliente27,null);
        mascotaRepository.save(mascota27);

        Mascota mascota28 = new Mascota(null, "Rocky", "Boxer", 4, 20.0f, "Problemas respiratorios",
                "https://www.escuelacaninamaya.com/images/xboxer.jpg.pagespeed.ic.Tt_reX5QUy.jpg", new Date(), new Date(),
                null, 1, cliente28,null);
        mascotaRepository.save(mascota28);

        Mascota mascota29 = new Mascota(null, "Bella", "Shiba Inu", 2, 9.0f, "Problemas de ansiedad",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente29,null);
        mascotaRepository.save(mascota29);

        Mascota mascota30 = new Mascota(null, "Max", "Husky", 3, 18.5f, "Problemas de visión",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente30,null);
        mascotaRepository.save(mascota30);

        Mascota mascota31 = new Mascota(null, "Daisy", "Bulldog Francés", 2, 13.0f, "Problemas de audición",
                "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/fotolia_58776564-768x491.jpg",
                new Date(), new Date(), null, 1, cliente31,null);
        mascotaRepository.save(mascota31);

        Mascota mascota32 = new Mascota(null, "Zeus", "Pastor Alemán", 4, 27.0f, "Problemas de cadera",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente32,null);
        mascotaRepository.save(mascota32);

        Mascota mascota33 = new Mascota(null, "Coco", "Labrador", 3, 19.5f, "Problemas de peso",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente33,null);
        mascotaRepository.save(mascota33);

        Mascota mascota34 = new Mascota(null, "Milo", "Beagle", 2, 10.0f, "Problemas de alergia",
                "https://plus.unsplash.com/premium_photo-1681883365008-49aee3640625?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8YmVhZ2xlfGVufDB8fDB8fHww", new Date(), new Date(), null, 1,
                cliente34,null);
        mascotaRepository.save(mascota34);

        Mascota mascota35 = new Mascota(null, "Ruby", "Golden Retriever", 5, 22.0f, "Problemas de articulaciones",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente35,null);
        mascotaRepository.save(mascota35);

        Mascota mascota36 = new Mascota(null, "Oscar", "Poodle", 1, 6.0f, "Problemas de piel",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente36,null);
        mascotaRepository.save(mascota36);

        Mascota mascota37 = new Mascota(null, "Lucky", "Chihuahua", 2, 3.2f, "Problemas de ansiedad",
                "https://cdn.wamiz.fr/cdn-cgi/image/format=auto,quality=80,width=532,height=532,fit=cover/animal/breed/pictures/674ed014e4587255595455.jpg",
                new Date(), new Date(), null, 1, cliente37,null);
        mascotaRepository.save(mascota37);

        Mascota mascota38 = new Mascota(null, "Rex", "Dálmata", 3, 15.5f, "Problemas de audición",
                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-07Dalmatian1.jpg?itok=B_1aRoJh", new Date(), new Date(), null, 1,
                cliente38,null);
        mascotaRepository.save(mascota38);

        Mascota mascota39 = new Mascota(null, "Sasha", "Boxer", 4, 19.0f, "Problemas cardíacos",
                "https://adiestrar-perros.com/wp-content/uploads/2024/12/boxer-min-scaled-1024x1024-1.webp",
                new Date(), new Date(), null, 1, cliente39,null);
        mascotaRepository.save(mascota39);

        Mascota mascota40 = new Mascota(null, "Bruno", "Shiba Inu", 2, 8.5f, "Problemas de tiroides",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente40,null);
        mascotaRepository.save(mascota40);

        Mascota mascota41 = new Mascota(null, "Lola", "Bulldog", 3, 13.5f, "Problemas de piel",
                "https://www.tiendanimal.es/articulos/wp-content/uploads/2023/12/imagenes-raza-bulldog-ingles.jpg",
                new Date(), new Date(), null, 1, cliente41,null);
        mascotaRepository.save(mascota41);

        Mascota mascota42 = new Mascota(null, "Thor", "Pastor Belga", 4, 25.5f, "Displasia de cadera",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente42,null);
        mascotaRepository.save(mascota42);

        Mascota mascota43 = new Mascota(null, "Mia", "Beagle", 2, 9.8f, "Problemas digestivos",
                "https://static.vecteezy.com/system/resources/previews/008/026/049/non_2x/beagle-in-the-park-dog-in-grass-field-photo.jpg",
                new Date(), new Date(), null, 1, cliente43,null);
        mascotaRepository.save(mascota43);

        Mascota mascota44 = new Mascota(null, "Simba", "Golden Retriever", 5, 21.5f, "Cáncer",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente44,null);
        mascotaRepository.save(mascota44);

        Mascota mascota45 = new Mascota(null, "Nala", "Poodle", 1, 5.5f, "Problemas de tiroides",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente45,null);
        mascotaRepository.save(mascota45);

        Mascota mascota46 = new Mascota(null, "Roco", "Chihuahua", 2, 3.0f, "Problemas de conducta",
                "https://lacaseta.es/wp-content/uploads/2023/08/chihuahua.jpg", new Date(), new Date(), null, 1,
                cliente46,null);
        mascotaRepository.save(mascota46);

        Mascota mascota47 = new Mascota(null, "Luna", "Dálmata", 3, 14.5f, "Problemas hepáticos",
                "https://media.graphassets.com/resize=height:404,width:938/output=format:webp/6VF5NepyTBS8ln35NZxs?width=938",
                new Date(), new Date(), null, 1, cliente47,null);
        mascotaRepository.save(mascota47);

        Mascota mascota48 = new Mascota(null, "Rocky", "Boxer", 4, 18.0f, "Problemas respiratorios",
                "https://dinastiacachorros.com.co/wp-content/uploads/2024/11/Img-Dinastia-del-Cachorro-Raza-Individual-Home-boxer-colombia.png", new Date(), new Date(),
                null, 1, cliente48,null);
        mascotaRepository.save(mascota48);

        Mascota mascota49 = new Mascota(null, "Bella", "Shiba Inu", 2, 8.0f, "Problemas de ansiedad",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente49,null);
        mascotaRepository.save(mascota49);

        Mascota mascota50 = new Mascota(null, "Max", "Husky", 3, 17.5f, "Problemas de visión",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente50,null);
        mascotaRepository.save(mascota50);

        Mascota mascota51 = new Mascota(null, "Toby", "Labrador", 4, 22.0f, "Problemas de piel",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente1,null);
        mascotaRepository.save(mascota51);

        Mascota mascota52 = new Mascota(null, "Luna", "Bulldog", 3, 16.0f, "Problemas respiratorios",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHDI9oiEOUTcDwcITV7QxWQkUfH1ijOw0RqQ&s", new Date(), new Date(), null, 1,
                cliente2,null);
        mascotaRepository.save(mascota52);

        Mascota mascota53 = new Mascota(null, "Rocky", "Beagle", 2, 11.5f, "Alergia alimentaria",
                "https://cdn0.uncomo.com/es/posts/9/3/9/es_importante_que_un_beagle_sea_de_raza_50939_0_600.jpg",
                new Date(), new Date(), null, 1, cliente3,null);
        mascotaRepository.save(mascota53);

        Mascota mascota54 = new Mascota(null, "Bella", "Golden Retriever", 5, 26.0f, "Displasia de cadera",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente4,null);
        mascotaRepository.save(mascota54);

        Mascota mascota55 = new Mascota(null, "Max", "Poodle", 1, 7.5f, "Problemas dentales",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente5,null);
        mascotaRepository.save(mascota55);

        Mascota mascota56 = new Mascota(null, "Daisy", "Chihuahua", 2, 3.5f, "Hipoglucemia",
                "https://goldenretrieverperu.com/wp-content/uploads/2021/11/chihuahua1.jpg", new Date(), new Date(), null, 1,
                cliente6,null);
        mascotaRepository.save(mascota56);

        Mascota mascota57 = new Mascota(null, "Charlie", "Dálmata", 4, 19.0f, "Sordera congénita",
                "https://www.zooplus.es/magazine/wp-content/uploads/2020/01/dalmata-1.jpg",
                new Date(), new Date(), null, 1, cliente7,null);
        mascotaRepository.save(mascota57);

        Mascota mascota58 = new Mascota(null, "Molly", "Boxer", 3, 21.5f, "Cardiopatía",
                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-07Boxer1.jpg?itok=Y2i45vCP", new Date(), new Date(),
                null, 1, cliente8,null);
        mascotaRepository.save(mascota58);

        Mascota mascota59 = new Mascota(null, "Buddy", "Shiba Inu", 2, 10.5f, "Dermatitis",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente9,null);
        mascotaRepository.save(mascota59);

        Mascota mascota60 = new Mascota(null, "Lola", "Husky", 3, 18.0f, "Hipotiroidismo",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente10,null);
        mascotaRepository.save(mascota60);

        Mascota mascota61 = new Mascota(null, "Zeus", "Bulldog Francés", 4, 13.5f, "Problemas oculares",
                "https://blog.dogfydiet.com/wp-content/uploads/2023/05/Caracteristicas-bulldog-ingles.jpg",
                new Date(), new Date(), null, 1, cliente11,null);
        mascotaRepository.save(mascota61);

        Mascota mascota62 = new Mascota(null, "Coco", "Pastor Alemán", 5, 27.5f, "Displasia de codo",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente12,null);
        mascotaRepository.save(mascota62);

        Mascota mascota63 = new Mascota(null, "Milo", "Labrador", 2, 20.0f, "Obesidad",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente13,null);
        mascotaRepository.save(mascota63);

        Mascota mascota64 = new Mascota(null, "Ruby", "Beagle", 3, 12.0f, "Epilepsia",
                "https://img.freepik.com/fotos-premium/perros-beagle-vuelven-mirar-lado-sospecha_36755-34.jpg?semt=ais_hybrid&w=740", new Date(), new Date(), null, 1,
                cliente14,null);
        mascotaRepository.save(mascota64);

        Mascota mascota65 = new Mascota(null, "Oscar", "Golden Retriever", 4, 23.5f, "Artritis",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente15,null);
        mascotaRepository.save(mascota65);

        Mascota mascota66 = new Mascota(null, "Lucky", "Poodle", 1, 6.5f, "Problemas renales",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente16,null);
        mascotaRepository.save(mascota66);

        Mascota mascota67 = new Mascota(null, "Rex", "Chihuahua", 2, 4.5f, "Luxación de rótula",
                "https://www.kokogenetics.com/_nuxt/img/106.09284bb.webp",
                new Date(), new Date(), null, 1, cliente17,null);
        mascotaRepository.save(mascota67);

        Mascota mascota68 = new Mascota(null, "Sasha", "Dálmata", 3, 16.5f, "Cálculos urinarios",
                "https://centralpetsperu.com/wp-content/uploads/2022/03/dalmata1.jpg", new Date(), new Date(), null, 1,
                cliente18,null);
        mascotaRepository.save(mascota68);

        Mascota mascota69 = new Mascota(null, "Bruno", "Boxer", 4, 20.5f, "Problemas cardíacos",
                "https://www.muyinteresante.com/wp-content/uploads/sites/5/2022/10/12/6346a2c72a77a.jpeg",
                new Date(), new Date(), null, 1, cliente19,null);
        mascotaRepository.save(mascota69);

        Mascota mascota70 = new Mascota(null, "Lola", "Shiba Inu", 2, 9.0f, "Alergia al polen",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente20,null);
        mascotaRepository.save(mascota70);

        Mascota mascota71 = new Mascota(null, "Thor", "Bulldog", 3, 14.5f, "Problemas de piel",
                "https://blog.dogfydiet.com/wp-content/uploads/2023/05/Caracteristicas-bulldog-ingles.jpg",
                new Date(), new Date(), null, 1, cliente21,null);
        mascotaRepository.save(mascota71);

        Mascota mascota72 = new Mascota(null, "Mia", "Pastor Belga", 4, 25.0f, "Displasia de cadera",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente22,null);
        mascotaRepository.save(mascota72);

        Mascota mascota73 = new Mascota(null, "Simba", "Beagle", 2, 10.0f, "Problemas digestivos",
                "https://goldenretrieverperu.com/wp-content/uploads/2021/11/beagle3.jpg",
                new Date(), new Date(), null, 1, cliente23,null);
        mascotaRepository.save(mascota73);

        Mascota mascota74 = new Mascota(null, "Nala", "Golden Retriever", 5, 24.0f, "Cáncer",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente24,null);
        mascotaRepository.save(mascota74);

        Mascota mascota75 = new Mascota(null, "Roco", "Poodle", 1, 5.0f, "Problemas de tiroides",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente25,null);
        mascotaRepository.save(mascota75);

        Mascota mascota76 = new Mascota(null, "Luna", "Chihuahua", 2, 3.8f, "Problemas de conducta",
                "https://caracol.com.co/resizer/v2/D627YQLQEBC27I5UQZ2Y44ZG5U.jpg?auth=342359cc2a7f8feeda6a0782ffdbaee21c8ee871bcebb97c5e87ef1b43f2483f&width=1440&height=1080&quality=70&smart=true", new Date(), new Date(), null, 1,
                cliente26,null);
        mascotaRepository.save(mascota76);

        Mascota mascota77 = new Mascota(null, "Rocky", "Dálmata", 3, 15.0f, "Problemas hepáticos",
                "https://cdn-coodb.nitrocdn.com/YoOVXLwRMctAOcRroQYMJHRPeNnvDFno/assets/images/optimized/rev-408478d/topcriadores.com/wp-content/uploads/2021/02/g.jpg",
                new Date(), new Date(), null, 1, cliente27,null);
        mascotaRepository.save(mascota77);

        Mascota mascota78 = new Mascota(null, "Bella", "Boxer", 4, 19.5f, "Problemas respiratorios",
                "https://image.petmd.com/files/inline-images/boxer-dog-3.jpg?VersionId=w_yp1hieep9vzAu5UslHVi4.ZC3FJnz9", new Date(), new Date(),
                null, 1, cliente28,null);
        mascotaRepository.save(mascota78);

        Mascota mascota79 = new Mascota(null, "Max", "Shiba Inu", 2, 8.8f, "Problemas de ansiedad",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente29,null);
        mascotaRepository.save(mascota79);

        Mascota mascota80 = new Mascota(null, "Daisy", "Husky", 3, 17.0f, "Problemas de visión",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente30,null);
        mascotaRepository.save(mascota80);

        Mascota mascota81 = new Mascota(null, "Charlie", "Bulldog Francés", 2, 12.5f, "Problemas de audición",
                "https://mivet.com/wp-content/uploads/2024/10/shutterstock_335066660.jpg",
                new Date(), new Date(), null, 1, cliente31,null);
        mascotaRepository.save(mascota81);

        Mascota mascota82 = new Mascota(null, "Molly", "Pastor Alemán", 4, 26.5f, "Problemas de cadera",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente32,null);
        mascotaRepository.save(mascota82);

        Mascota mascota83 = new Mascota(null, "Buddy", "Labrador", 3, 20.0f, "Problemas de peso",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente33,null);
        mascotaRepository.save(mascota83);

        Mascota mascota84 = new Mascota(null, "Lola", "Beagle", 2, 11.0f, "Problemas de alergia",
                "https://goldenretrieverperu.com/wp-content/uploads/2021/11/beagle3.jpg", new Date(), new Date(), null, 1,
                cliente34,null);
        mascotaRepository.save(mascota84);

        Mascota mascota85 = new Mascota(null, "Zeus", "Golden Retriever", 5, 22.5f, "Problemas de articulaciones",
                "https://s1.elespanol.com/2021/11/11/curiosidades/mascotas/626448862_214582614_1706x1280.jpg",
                new Date(), new Date(), null, 1, cliente35,null);
        mascotaRepository.save(mascota85);

        Mascota mascota86 = new Mascota(null, "Coco", "Poodle", 1, 6.8f, "Problemas de piel",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente36,null);
        mascotaRepository.save(mascota86);

        Mascota mascota87 = new Mascota(null, "Milo", "Chihuahua", 2, 3.2f, "Problemas de ansiedad",
                "https://arquivet.com/img/cms/Todo%20lo%20que%20debes%20saber%20sobre%20los%20perros%20chihuahua.jpg",
                new Date(), new Date(), null, 1, cliente37,null);
        mascotaRepository.save(mascota87);

        Mascota mascota88 = new Mascota(null, "Ruby", "Dálmata", 3, 14.0f, "Problemas de audición",
                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-07Dalmatian2.jpg?itok=WgnY-HKT", new Date(), new Date(), null, 1,
                cliente38,null);
        mascotaRepository.save(mascota88);

        Mascota mascota89 = new Mascota(null, "Oscar", "Boxer", 4, 18.5f, "Problemas cardíacos",
                "https://www.zaunk.com/wp-content/uploads/2020/05/boxer-caracteristicas-scaled.jpg.webp",
                new Date(), new Date(), null, 1, cliente39,null);
        mascotaRepository.save(mascota89);

        Mascota mascota90 = new Mascota(null, "Lucky", "Shiba Inu", 2, 8.0f, "Problemas de tiroides",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente40,null);
        mascotaRepository.save(mascota90);

        Mascota mascota91 = new Mascota(null, "Rex", "Bulldog", 3, 13.0f, "Problemas de piel",
                "https://media.cnn.com/api/v1/images/stellar/prod/cnne-1224502-220615105053-unhealthy-english-bulldogs-full-169.jpeg?q=w_1110,c_fill",
                new Date(), new Date(), null, 1, cliente41,null);
        mascotaRepository.save(mascota91);

        Mascota mascota92 = new Mascota(null, "Sasha", "Pastor Belga", 4, 24.5f, "Displasia de cadera",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente42,null);
        mascotaRepository.save(mascota92);

        Mascota mascota93 = new Mascota(null, "Bruno", "Beagle", 2, 9.5f, "Problemas digestivos",
                "https://limaonepets.com/wp-content/uploads/2023/05/bea-3-1024x1024.png",
                new Date(), new Date(), null, 1, cliente43,null);
        mascotaRepository.save(mascota93);

        Mascota mascota94 = new Mascota(null, "Lola", "Golden Retriever", 5, 21.0f, "Cáncer",
                "https://cdn.dogsplanet.com/wp-content/uploads/2019/10/beagle-sentado.jpg", new Date(), new Date(),
                null, 1, cliente44,null);
        mascotaRepository.save(mascota94);

        Mascota mascota95 = new Mascota(null, "Thor", "Poodle", 1, 5.5f, "Problemas de tiroides",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente45,null);
        mascotaRepository.save(mascota95);

        Mascota mascota96 = new Mascota(null, "Mia", "Chihuahua", 2, 3.5f, "Problemas de conducta",
                "https://media.istockphoto.com/id/2162705183/es/foto/cute-chihuahua-dog.jpg?s=612x612&w=0&k=20&c=aw__EiyZtG54DC2wHnXCiKwjaazRVMeymnjtuJU-_r4=", new Date(), new Date(), null, 1,
                cliente46,null);
        mascotaRepository.save(mascota96);

        Mascota mascota97 = new Mascota(null, "Simba", "Dálmata", 3, 14.5f, "Problemas hepáticos",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Chien_sportif.jpg/250px-Chien_sportif.jpg",
                new Date(), new Date(), null, 1, cliente47,null);
        mascotaRepository.save(mascota97);

        Mascota mascota98 = new Mascota(null, "Nala", "Boxer", 4, 17.5f, "Problemas respiratorios",
                "https://d128mjo55rz53e.cloudfront.net/media/images/boxer-5.max-400x400.format-jpeg.jpg", new Date(), new Date(),
                null, 1, cliente48,null);
        mascotaRepository.save(mascota98);

        Mascota mascota99 = new Mascota(null, "Roco", "Shiba Inu", 2, 7.5f, "Problemas de ansiedad",
                "https://img.huffingtonpost.es/files/image_1200_720/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg",
                new Date(), new Date(), null, 1, cliente49,null);
        mascotaRepository.save(mascota99);

        Mascota mascota100 = new Mascota(null, "Luna", "Husky", 3, 16.0f, "Problemas de visión",
                "https://www.rover.com/blog/wp-content/uploads/2015/03/black-dog.jpg", new Date(), new Date(), null, 1,
                cliente50,null);
        mascotaRepository.save(mascota100);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // Creación de 10 tratamientos
        List<Tratamiento> tratamientos = Arrays.asList(
        new Tratamiento(1, "TRAT001", sdf.parse("2024-01-10"), "Desparasitación interna", veterinario2, mascota1, servicioConsulta, null),
        new Tratamiento(2, "TRAT002", new Date(), "Control de pulgas y garrapatas", veterinario1, mascota2, servicioCirugia, null),
        new Tratamiento(3, "TRAT003", new Date(), "Tratamiento antiinflamatorio", veterinario5, mascota3, servicioConsulta, null),
        new Tratamiento(4, "TRAT004", new Date(), "Antibiótico para infecciones", veterinario4, mascota4, servicioCirugia, null),
        new Tratamiento(5, "TRAT005", new Date(), "Analgésico postoperatorio", veterinario1, mascota5, servicioCirugia, null),
        new Tratamiento(6, "TRAT006", new Date(), "Reducción de estrés", veterinario6, mascota6, servicioHospitalizacion, null),
        new Tratamiento(7, "TRAT007", sdf.parse("2025-03-09"), "Cuidado renal", veterinario1, mascota7, servicioHospitalizacion, null),
        new Tratamiento(8, "TRAT008", sdf.parse("2024-12-24"), "Tratamiento digestivo", veterinario6, mascota8, servicioHospitalizacion, null),
        new Tratamiento(9, "TRAT009", sdf.parse("2025-04-04"), "Terapia para articulaciones", veterinario3, mascota9, servicioConsulta, null),
        new Tratamiento(10, "TRAT010", sdf.parse("2024-05-02"), "Tratamiento para infecciones urinarias", veterinario6, mascota10, servicioConsulta, null)
        );
        tratamientoRepository.saveAll(tratamientos);

        // Creación de medicamentos usando Builder Pattern
        List<Medicamento> medicamentos = Arrays.asList(
                Medicamento.builder()
                .nombre("Advantix")
                .precioCompra(150.0f)
                .precioVenta(200.0f)
                .unidadesDisponibles(50)
                .unidadesVendidas(10)
                .build(),
                
                Medicamento.builder()
                .nombre("Drontal")
                .precioCompra(100.0f)
                .precioVenta(130.0f)
                .unidadesDisponibles(60)
                .unidadesVendidas(15)
                .build(),
                
                Medicamento.builder()
                .nombre("Vetoquinol")
                .precioCompra(80.0f)
                .precioVenta(110.0f)
                .unidadesDisponibles(40)
                .unidadesVendidas(20)
                .build(),
                
                Medicamento.builder()
                .nombre("Cortaf")
                .precioCompra(75.0f)
                .precioVenta(100.0f)
                .unidadesDisponibles(45)
                .unidadesVendidas(12)
                .build(),
                
                Medicamento.builder()
                .nombre("Milbemax")
                .precioCompra(120.0f)
                .precioVenta(150.0f)
                .unidadesDisponibles(70)
                .unidadesVendidas(8)
                .build(),
                
                Medicamento.builder()
                .nombre("Metronidazol")
                .precioCompra(90.0f)
                .precioVenta(120.0f)
                .unidadesDisponibles(55)
                .unidadesVendidas(16)
                .build(),
                
                Medicamento.builder()
                .nombre("Rimadyl")
                .precioCompra(200.0f)
                .precioVenta(250.0f)
                .unidadesDisponibles(30)
                .unidadesVendidas(5)
                .build(),
                
                Medicamento.builder()
                .nombre("Panacur")
                .precioCompra(85.0f)
                .precioVenta(110.0f)
                .unidadesDisponibles(50)
                .unidadesVendidas(18)
                .build(),
                
                Medicamento.builder()
                .nombre("Zylkene")
                .precioCompra(150.0f)
                .precioVenta(180.0f)
                .unidadesDisponibles(35)
                .unidadesVendidas(6)
                .build(),
                
                Medicamento.builder()
                .nombre("Bexacat")
                .precioCompra(110.0f)
                .precioVenta(140.0f)
                .unidadesDisponibles(40)
                .unidadesVendidas(7)
                .build()
        );
        
        medicamentoRepository.saveAll(medicamentos);

        // Creación de una factura
        Factura factura = new Factura(null, new Date(), 5000f, false, "Efectivo", cliente1 , tratamientos.get(1), null,null );
        facturaRepository.save(factura);

        Factura factura2 = new Factura(null, new Date(), 5000f, false, "Efectivo", cliente2 , tratamientos.get(2), null,null );
        facturaRepository.save(factura2);

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
                "AGENDADA"
        );
        citaRepository.save(cita1);

        Cita cita2 = new Cita(null,
        new Date(System.currentTimeMillis() + 7200 * 1000),
        "Sucursal Centro",
        mascotaRepository.findById(2).orElse(null),
        veterinarioRepository.findById(2).orElse(null),
        servicioRepository.findById(2).orElse(null),
                "AGENDADA"
        );
        citaRepository.save(cita2);

        Cita cita3 = new Cita(null,
        new Date(System.currentTimeMillis() + 10800 * 1000),
        "Sucursal Sur",
        mascotaRepository.findById(3).orElse(null),
        veterinarioRepository.findById(1).orElse(null),
        servicioRepository.findById(3).orElse(null),
                "AGENDADA"
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

    private UserEntity saveCliente(Cliente cliente){
        UserEntity user = new UserEntity();
        user.setUsername(cliente.getNombreUsuario());
        user.setPassword(passwordEncoder.encode(cliente.getContrasena()));
        Role roles = roleRepository.findByName("CLIENTE").get();
        user.setRoles(List.of(roles));
        return userRepository.save(user);
    }

    private UserEntity saveVeterinario(Veterinario veterinario){
        UserEntity user = new UserEntity();
        user.setUsername(veterinario.getNombreUsuario());
        user.setPassword(passwordEncoder.encode(veterinario.getContrasena()));
        Role roles = roleRepository.findByName("VETERINARIO").get();
        user.setRoles(List.of(roles));
        return userRepository.save(user);
    }

    private UserEntity saveAdministrador(Administrador administrador){
        UserEntity user = new UserEntity();
        user.setUsername(administrador.getNombreUsuario());
        user.setPassword(passwordEncoder.encode(administrador.getContrasena()));
        Role roles = roleRepository.findByName("ADMIN").get();
        user.setRoles(List.of(roles));
        return userRepository.save(user);
    }
}