package com.herprogramacion.crmleads;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

/**
 * Screen para el manejo de los leads en la app CRM
 */
public class LeadsActivity extends AppCompatActivity {
    private static final String LOGCAT = null ;
    DBController dbController;
    TextView txtContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leads);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LeadsFragment leadsFragment = (LeadsFragment)
                getSupportFragmentManager().findFragmentById(R.id.leads_container);

        /**se crea la base de datos
         *
         */
        dbController = new DBController(LeadsActivity.this);

        dbController.open();
        Cursor cursor = dbController.getData();
        if (cursor.moveToFirst()) {
            dbController.close();
        } else {
            createDummys();
            dbController.close();
        }

            if (leadsFragment == null) {
                leadsFragment = LeadsFragment.newInstance();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.leads_container, leadsFragment)
                        .commit();
            }

        }




    private void createDummys(){
        Log.d(LOGCAT,"entro a createDummys");
        dbController.open();
        dbController.insertData("Fundamentos del diseño web - semanal",
                "Costo:$ 3,500*" +
                        "Fecha del curso regular:\n" +
                        "De lunes 19 a viernes 23 de Septiembre del 2016.\n" +
                        "Horario: 2 pm a 6 pm" +
                        "Duración: 20 horas.\n" +
                        "Fechas para curso regular:\n" +
                        "Del lunes 19 al viernes 23 de septiembre de 2016.\n" +
                        "Horario: De 2 pm a 6 pm." +
                        "Objetivos de la prueba:\n" +
                        "El participante demostrará conocimientos suficientes sobre:\n" +
                        "\n" +
                        "El manejo y operación del editor de texto con sistema EMMET.\n" +
                        "HTML y CSS a nivel intermedio.\n" +
                        " Maquetación y prototipado Web.\n" +
                        "Sistemas Adaptativos para Web dirigidas a móviles." +
                        "Temas del curso:\n" +
                        "\n" +
                        "Unidad 1: Conceptos básicos de la web.\n" +
                        "¿Qué es front-end?\n" +
                        "Unidad 2: Frameworks, plugins, librerías, widgets.\n" +
                        "Jquery\n" +
                        "Bootstrap\n" +
                        "Foundation\n" +
                        "Unidad 3: Herramientas de creación de código.\n" +
                        "SublimeText\n" +
                        "Atom\n" +
                        "Plugin Emmet\n" +
                        "Unidad 4: Tecnologías implicadas en el desarrollo front-end.\n" +
                        "Instalación de un servidor local y servicios disponibles en la nube para tu web\n" +
                        "¿Qué es responsive design?\n" +
                        "Html5\n" +
                        "CSS3\n" +
                        "Unidad 5: Fundamentos de la maquetación.\n" +
                        "Prototipado para web.\n" +
                        "Reglas CSS.\n" +
                        "Posicionamiento y visualización en HTML.\n" +
                        "Tipos de elementos en HTML.\n" +
                        "Unidad 6: Ejemplo práctico de una maquetación web.\n" +
                        "Contenido y diseño de la estructura web.\n" +
                        "Cabecera y menú de la web.\n" +
                        "Contenido de la web.\n" +
                        "Pie de página de la web.\n" +
                        "Unidad 7: Frameworks para maquetación.\n" +
                        "Foundation Zurb.\n" +
                        "Bootstrap.\n" +
                        "Boilerplate.",
                "19-09-2016");


        dbController.insertData("Fundamentos del diseño web - sabatino",
                "Costo:$ 3,500*" +
                        "Fecha del curso sabatino:\n" +
                        "15, 22 y 29 de octubre del 2016. \n" +
                        "Horario: 9 am a 4 pm" +
                        "Duración: 20 horas.\n" +
                        "Fechas para curso regular:\n" +
                        "Objetivos de la prueba:\n" +
                        "El participante demostrará conocimientos suficientes sobre:\n" +
                        "\n" +
                        "El manejo y operación del editor de texto con sistema EMMET.\n" +
                        "HTML y CSS a nivel intermedio.\n" +
                        " Maquetación y prototipado Web.\n" +
                        "Sistemas Adaptativos para Web dirigidas a móviles." +
                        "Temas del curso:\n" +
                        "\n" +
                        "Unidad 1: Conceptos básicos de la web.\n" +
                        "¿Qué es front-end?\n" +
                        "Unidad 2: Frameworks, plugins, librerías, widgets.\n" +
                        "Jquery\n" +
                        "Bootstrap\n" +
                        "Foundation\n" +
                        "Unidad 3: Herramientas de creación de código.\n" +
                        "SublimeText\n" +
                        "Atom\n" +
                        "Plugin Emmet\n" +
                        "Unidad 4: Tecnologías implicadas en el desarrollo front-end.\n" +
                        "Instalación de un servidor local y servicios disponibles en la nube para tu web\n" +
                        "¿Qué es responsive design?\n" +
                        "Html5\n" +
                        "CSS3\n" +
                        "Unidad 5: Fundamentos de la maquetación.\n" +
                        "Prototipado para web.\n" +
                        "Reglas CSS.\n" +
                        "Posicionamiento y visualización en HTML.\n" +
                        "Tipos de elementos en HTML.\n" +
                        "Unidad 6: Ejemplo práctico de una maquetación web.\n" +
                        "Contenido y diseño de la estructura web.\n" +
                        "Cabecera y menú de la web.\n" +
                        "Contenido de la web.\n" +
                        "Pie de página de la web.\n" +
                        "Unidad 7: Frameworks para maquetación.\n" +
                        "Foundation Zurb.\n" +
                        "Bootstrap.\n" +
                        "Boilerplate.",
                "15-10-2016");


        dbController.insertData("Linux Administrator - semanal",
                "Costo:$ 3,800*"+
                        "Fecha del curso regular: De lunes 26 a viernes 30 de septiembre del 2016.\n" +
                        "Horario: 9 am a 4 pm" +
                        "Objetivos de la prueba:\n" +
                        "El participante demostrará conocimientos suficientes sobre:\n" +
                        "\n" +
                        "La Instalación del sistema operativo Linux Centos.\n" +
                        "La configuración de entorno Grafico Linux.\n" +
                        "La configuración de Impresión en Linux.\n" +
                        "Configuración y manejo de las Redes TCP/IP.\n" +
                        "Programar Tareas en el Sistema operativo Linux.\n" +
                        "La configuración y manejo del Acceso Remoto.\n" +
                        "Gestión y administración del sistema operativo mediante la terminal.\n" +
                        "El Manejo de SSH.\n" +
                        "El manejo de gestión de permisos y seguridad.\n" +
                        "Temas del curso:\n" +
                        "Unidad 1.- Instalación del SistemaOperativo y Ajustes posteriores\n" +
                        "\n" +
                        "Introducción\n" +
                        "Sistema Operativo Unix.\n" +
                        "Sistema Operativo Linux.\n" +
                        "Requerimientos de Hardware de Linux.\n" +
                        "Organización de Linux.\n" +
                        "Sistema de Archivos en Linux.\n" +
                        "Procesamiento de Texto.\n" +
                        "Características del Sistema Linux.\n" +
                        "Software disponible en Linux.\n" +
                        "Distribuciones Linux.\n" +
                        "Estándar de Jerarquía de Sistema de Archivos.\n" +
                        "Estructura de los directorios general.\n" +
                        "Estructura de Archivos.\n" +
                        "Instalación Centos CentOS 6.5.\n" +
                        "Editor de texto VI y VIM.\n" +
                        "Uso de disco de rescate en CentOS 6.5.\n" +
                        "Gestión de memoria Swap.\n" +
                        "\n" +
                        "Unidad 2.- Administración del Sistema de Archivos.\n" +
                        "\n" +
                        "Límites de tamaño.\n" +
                        "Sistema de archivos de gran tamaño.\n" +
                        "Extents.\n" +
                        "Swapinees.\n" +
                        "Commit.\n" +
                        "FSCK (File System Check).\n" +
                        "Uso de dd.\n" +
                        "\n" +
                        "Unidad 3.- Administración de Software y servicios.\n" +
                        "\n" +
                        "Gestión de paquetes RPM.\n" +
                        "Instalación de paquetes.\n" +
                        "Gestor de Servicios.\n" +
                        "Secuencia de arranque.\n" +
                        "Arranque y parada de lo servicios.\n" +
                        "Envío de señales a los procesos.\n" +
                        "\n" +
                        "Unidad 4.- Gestión de usuarios, grupos y privilegios.\n" +
                        "\n" +
                        "Gestión de cuentas de usuario.\n" +
                        "Tipos de usuarios.\n" +
                        "Archivos de configuración.\n" +
                        "Gestion de cuentas de grupos.\n" +
                        "SUDO.\n" +
                        "\n" +
                        "Unidad 5. Permisos y Atributos del Sistema de Archivos.\n" +
                        "\n" +
                        "Permisos de ficheros.\n" +
                        "Comando Umask.\n" +
                        "Comando chmod.\n" +
                        "Comando chown.\n" +
                        "\n" +
                        "Unidad 6.- Herramientas básicas del Sistema Operativo.\n" +
                        "\n" +
                        "Compresión y descompresión de archivos.\n" +
                        "Gestión de procesos y trabajos.\n" +
                        "Configuración y uso de crond.\n" +
                        "Usando cron Implementar y Administrar Cuotas De Disco (Disk Quotas) en Linux.\n" +
                        "\n" +
                        "Unidad 7.- Redes\n" +
                        "\n" +
                        "Configuración de red.\n" +
                        "Configuración del fichero resolv.conf.\n" +
                        "Iptables.\n" +
                        "Protocolo TCP.\n" +
                        "Protocolo UDP.\n" +
                        "Protocolo ICMP.\n" +
                        "Protocolo SSH.\n" +
                        "Historia del SSH.\n" +
                        "Versiones de SSH.\n" +
                        "Características de SSH.\n" +
                        "Instalacion y Configuración.\n" +
                        "Secuencia de eventos de una conexión SSH.\n" +
                        "Autenticación en SSH.\n" +
                        "Canales en SSH.\n" +
                        "Servidores FTP.\n" +
                        "Instalación y Configuración de FTP.\n" +
                        "Modo activo.\n" +
                        "Modo pasivo.",
                "26-09-2016");

        dbController.insertData("Linux Administrator - sabatino",
                "Costo:$ 3,800*"+
                        "Fecha del curso sabatino: 5, 12, 19 y 26 de noviembre del 2016.\n" +
                        "Horario: 9 am a 5 pm" +
                        "Objetivos de la prueba:\n" +
                        "El participante demostrará conocimientos suficientes sobre:\n" +
                        "\n" +
                        "La Instalación del sistema operativo Linux Centos.\n" +
                        "La configuración de entorno Grafico Linux.\n" +
                        "La configuración de Impresión en Linux.\n" +
                        "Configuración y manejo de las Redes TCP/IP.\n" +
                        "Programar Tareas en el Sistema operativo Linux.\n" +
                        "La configuración y manejo del Acceso Remoto.\n" +
                        "Gestión y administración del sistema operativo mediante la terminal.\n" +
                        "El Manejo de SSH.\n" +
                        "El manejo de gestión de permisos y seguridad.\n" +
                        "Temas del curso:\n" +
                        "Unidad 1.- Instalación del SistemaOperativo y Ajustes posteriores\n" +
                        "\n" +
                        "Introducción\n" +
                        "Sistema Operativo Unix.\n" +
                        "Sistema Operativo Linux.\n" +
                        "Requerimientos de Hardware de Linux.\n" +
                        "Organización de Linux.\n" +
                        "Sistema de Archivos en Linux.\n" +
                        "Procesamiento de Texto.\n" +
                        "Características del Sistema Linux.\n" +
                        "Software disponible en Linux.\n" +
                        "Distribuciones Linux.\n" +
                        "Estándar de Jerarquía de Sistema de Archivos.\n" +
                        "Estructura de los directorios general.\n" +
                        "Estructura de Archivos.\n" +
                        "Instalación Centos CentOS 6.5.\n" +
                        "Editor de texto VI y VIM.\n" +
                        "Uso de disco de rescate en CentOS 6.5.\n" +
                        "Gestión de memoria Swap.\n" +
                        "\n" +
                        "Unidad 2.- Administración del Sistema de Archivos.\n" +
                        "\n" +
                        "Límites de tamaño.\n" +
                        "Sistema de archivos de gran tamaño.\n" +
                        "Extents.\n" +
                        "Swapinees.\n" +
                        "Commit.\n" +
                        "FSCK (File System Check).\n" +
                        "Uso de dd.\n" +
                        "\n" +
                        "Unidad 3.- Administración de Software y servicios.\n" +
                        "\n" +
                        "Gestión de paquetes RPM.\n" +
                        "Instalación de paquetes.\n" +
                        "Gestor de Servicios.\n" +
                        "Secuencia de arranque.\n" +
                        "Arranque y parada de lo servicios.\n" +
                        "Envío de señales a los procesos.\n" +
                        "\n" +
                        "Unidad 4.- Gestión de usuarios, grupos y privilegios.\n" +
                        "\n" +
                        "Gestión de cuentas de usuario.\n" +
                        "Tipos de usuarios.\n" +
                        "Archivos de configuración.\n" +
                        "Gestion de cuentas de grupos.\n" +
                        "SUDO.\n" +
                        "\n" +
                        "Unidad 5. Permisos y Atributos del Sistema de Archivos.\n" +
                        "\n" +
                        "Permisos de ficheros.\n" +
                        "Comando Umask.\n" +
                        "Comando chmod.\n" +
                        "Comando chown.\n" +
                        "\n" +
                        "Unidad 6.- Herramientas básicas del Sistema Operativo.\n" +
                        "\n" +
                        "Compresión y descompresión de archivos.\n" +
                        "Gestión de procesos y trabajos.\n" +
                        "Configuración y uso de crond.\n" +
                        "Usando cron Implementar y Administrar Cuotas De Disco (Disk Quotas) en Linux.\n" +
                        "\n" +
                        "Unidad 7.- Redes\n" +
                        "\n" +
                        "Configuración de red.\n" +
                        "Configuración del fichero resolv.conf.\n" +
                        "Iptables.\n" +
                        "Protocolo TCP.\n" +
                        "Protocolo UDP.\n" +
                        "Protocolo ICMP.\n" +
                        "Protocolo SSH.\n" +
                        "Historia del SSH.\n" +
                        "Versiones de SSH.\n" +
                        "Características de SSH.\n" +
                        "Instalacion y Configuración.\n" +
                        "Secuencia de eventos de una conexión SSH.\n" +
                        "Autenticación en SSH.\n" +
                        "Canales en SSH.\n" +
                        "Servidores FTP.\n" +
                        "Instalación y Configuración de FTP.\n" +
                        "Modo activo.\n" +
                        "Modo pasivo.",
                "05-11-2016");

        dbController.insertData("Programador de Aplicaciones móviles Jr. utilizando Android - semanal",
                "Costo: $ 3,600*" +
                        "Fechas para curso regular:\n" +
                        "Del lunes 03 al viernes 07 de octubre de 2016.\n" +
                        "Horario: De 1 pm a 6 pm." +
                        "Duración: 24 horas." +
                        "Objetivos de la prueba:\n" +
                        "El participante demostrará conocimientos suficientes sobre:\n" +
                        "\n" +
                        "La operación de los Servicios Android.\n" +
                        "El manejo adecuado de las Herramientas de desarrollo en Android Studio.\n" +
                        "El uso e implementación de Frameworks.\n" +
                        "El uso e implementación de Fragments.\n" +
                        "El manejo Procesos e hilos en Android.\n" +
                        " La asignación adecuada de los Recursos de una aplicación desarrollada en Android Studio.\n" +
                        "Manejar el almacenamiento de datos en un dispositivo móvil.\n" +
                        "La implantación de la Seguridad y permisos en el sistema operativo Android.\n" +
                        "\n" +
                        "Temas del curso:\n" +
                        "\n" +
                        "Mundo Móvil.\n" +
                        "Conociendo el sistema de Android Studio\n" +
                        "Introducción al Mundo Movil.\n" +
                        "Diccionario Android.\n" +
                        "Conociendo lenguaje JAVA.\n" +
                        "En esta sección estaremos haciendo una introducción al lenguaje de programación JAVA en el cual tiene un paradigma POO(Programación orientada a Objetos)\n" +
                        "Qué es Java.\n" +
                        "Instalando IntelliJ.\n" +
                        "Introducción al manejo de IntelliJ.\n" +
                        "Esta plataforma nos ayuda a desarrollar Aplicaciones Standalone-apps para el entorno de programación Java\n" +
                        "Manejo del IDE IntelliJ.\n" +
                        "Segunda parte de interfaz.\n" +
                        "Clase y Objetos.\n" +
                        "Detalles de cómo programar herencias en JAVA\n" +
                        "Clase y Objetos.\n" +
                        "Variables y Datos.\n" +
                        "Herencia.\n" +
                        "Una de las caracteristicas del POO en JAVA\n" +
                        "Herencia.\n" +
                        "Encapsulamiento.\n" +
                        "Una de las caracteristicas de la programación orientada a objetos en JAVA\n" +
                        "Encapsulamiento.\n" +
                        "Métodos.\n" +
                        "Característica de la programaciÓn orientada a objetos\n" +
                        "Introducción a los métodos.\n" +
                        "Polimorfismo y sobrecarga.\n" +
                        "Aditamentos avanzados de JAVA.\n" +
                        "Básico para Android\n" +
                        "Clases Abstractas.\n" +
                        "Interfaces.\n" +
                        "Arquitectura de Android Studio.\n" +
                        "Introducción a la arquitectura de Android\n" +
                        "Estructura de Android.\n" +
                        "Conociendo las herramientas de Android Studio.\n" +
                        "Segunda parte de Android Studio conociendo nuevas herramientas\n" +
                        "Estructura de archivos.\n" +
                        "Instalacion de Android Estudio.\n" +
                        "Conociendo Android Studio Iniciando.\n" +
                        "Conociendo Android Studio GITHUB.\n" +
                        "Conociendo Android Studio AVD.\n" +
                        "Conociendo Android Studio ADM.",
                "03-10-2016");

        dbController.insertData("Programador de Aplicaciones móviles Jr. utilizando Android - sabatino",
                "Costo: $ 3,600*" +
                        "Fecha del curso sabatino: 24 de septiembre, 01 y 08 de octubre del 2016.\n" +
                        "Horario: 9 am a 6 pm" +
                        "Duración: 24 horas." +
                        "Objetivos de la prueba:\n" +
                        "El participante demostrará conocimientos suficientes sobre:\n" +
                        "\n" +
                        "La operación de los Servicios Android.\n" +
                        "El manejo adecuado de las Herramientas de desarrollo en Android Studio.\n" +
                        "El uso e implementación de Frameworks.\n" +
                        "El uso e implementación de Fragments.\n" +
                        "El manejo Procesos e hilos en Android.\n" +
                        " La asignación adecuada de los Recursos de una aplicación desarrollada en Android Studio.\n" +
                        "Manejar el almacenamiento de datos en un dispositivo móvil.\n" +
                        "La implantación de la Seguridad y permisos en el sistema operativo Android.\n" +
                        "\n" +
                        "Temas del curso:\n" +
                        "\n" +
                        "Mundo Móvil.\n" +
                        "Conociendo el sistema de Android Studio\n" +
                        "Introducción al Mundo Movil.\n" +
                        "Diccionario Android.\n" +
                        "Conociendo lenguaje JAVA.\n" +
                        "En esta sección estaremos haciendo una introducción al lenguaje de programación JAVA en el cual tiene un paradigma POO(Programación orientada a Objetos)\n" +
                        "Qué es Java.\n" +
                        "Instalando IntelliJ.\n" +
                        "Introducción al manejo de IntelliJ.\n" +
                        "Esta plataforma nos ayuda a desarrollar Aplicaciones Standalone-apps para el entorno de programación Java\n" +
                        "Manejo del IDE IntelliJ.\n" +
                        "Segunda parte de interfaz.\n" +
                        "Clase y Objetos.\n" +
                        "Detalles de cómo programar herencias en JAVA\n" +
                        "Clase y Objetos.\n" +
                        "Variables y Datos.\n" +
                        "Herencia.\n" +
                        "Una de las caracteristicas del POO en JAVA\n" +
                        "Herencia.\n" +
                        "Encapsulamiento.\n" +
                        "Una de las caracteristicas de la programación orientada a objetos en JAVA\n" +
                        "Encapsulamiento.\n" +
                        "Métodos.\n" +
                        "Característica de la programaciÓn orientada a objetos\n" +
                        "Introducción a los métodos.\n" +
                        "Polimorfismo y sobrecarga.\n" +
                        "Aditamentos avanzados de JAVA.\n" +
                        "Básico para Android\n" +
                        "Clases Abstractas.\n" +
                        "Interfaces.\n" +
                        "Arquitectura de Android Studio.\n" +
                        "Introducción a la arquitectura de Android\n" +
                        "Estructura de Android.\n" +
                        "Conociendo las herramientas de Android Studio.\n" +
                        "Segunda parte de Android Studio conociendo nuevas herramientas\n" +
                        "Estructura de archivos.\n" +
                        "Instalacion de Android Estudio.\n" +
                        "Conociendo Android Studio Iniciando.\n" +
                        "Conociendo Android Studio GITHUB.\n" +
                        "Conociendo Android Studio AVD.\n" +
                        "Conociendo Android Studio ADM.",
                "24-09-2016");
        //*showData();
        dbController.close();
    }

}
