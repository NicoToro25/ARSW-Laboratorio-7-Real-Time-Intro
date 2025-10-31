# Arquitecturas de Software (ARSW) - Laboratorio #7

## Spring, Websockets y ReactJS.

#### Nicolás Toro

[![Java](https://img.shields.io/badge/Java-17%2B-blue.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-Build-brightgreen.svg)](https://maven.apache.org/)

---

En este repositorio se muestra la solución de la introducción a Websockets y al laboratorio 7. Para ver la información detallada
entrar en la carpeta introducción o laboratorio7 para encontrar el enunciado

ESCRIBIR SOLUCIÓN

## Estructura del laboratorio

```bash
├───.idea
├───.mvn
│   └───wrapper
├───img
├───src
│   ├───main
│   │   ├───java
│   │   │   └───edu
│   │   │       └───eci
│   │   │           └───arsw
│   │   │               └───blueprints
│   │   │                   ├───controllers
│   │   │                   ├───filter
│   │   │                   │   └───impl
│   │   │                   ├───model
│   │   │                   ├───persistence
│   │   │                   │   └───impl
│   │   │                   └───services
│   │   └───resources
│   │       └───static
│   │           └───js
│   └───test
│       └───java
│           └───edu
│               └───eci
│                   └───arsw
│                       └───blueprints
│                           └───test
│                               └───persistence
│                                   └───impl
└───target
    ├───classes
    │   ├───edu
    │   │   └───eci
    │   │       └───arsw
    │   │           └───blueprints
    │   │               ├───controllers
    │   │               ├───filter
    │   │               │   └───impl
    │   │               ├───model
    │   │               ├───persistence
    │   │               │   └───impl
    │   │               └───services
    │   └───static
    │       └───js
    ├───generated-sources
    │   └───annotations
    ├───generated-test-sources
    │   └───test-annotations
    ├───maven-archiver
    ├───maven-status
    │   └───maven-compiler-plugin
    │       ├───compile
    │       │   └───default-compile
    │       └───testCompile
    │           └───default-testCompile
    ├───surefire-reports
    └───test-classes
        └───edu
            └───eci
                └───arsw
                    └───blueprints
                        └───test
                            └───persistence
                                └───impl


```
---

### Ejecutar el Proyecto

A continuación, se describen los pasos para ejecutar ambos proyectos en cualquier sistema operativo compatible con Java y Maven.

#### 1. Requisitos previos

- **Java 17** o superior instalado y configurado en el `PATH`.
- **Apache Maven** instalado y configurado en el `PATH`.
- (Opcional) Un IDE como IntelliJ IDEA, Eclipse o VS Code para facilitar la edición y ejecución.

Verifica las versiones instaladas ejecutando en la terminal:

```bash
java -version
mvn -version
```

#### 2. Clonar el repositorio

Si aún no tiene el repositorio localmente, clónelo con:

```bash
git clone https://github.com/NicoToro25/ARSW-Laboratorio-7-Real-Time-Intro.git
```

#### 3. Compilar los proyectos

Ejecutar el siguiente código

```bash
mvn clean package
```

#### 4. Ejecutar los proyectos

Ejecutar el siguiente código:

```bash
mvn exec:java@
```

> **Nota:** Si su IDE lo permite, también puede ejecutar directamente las clases principales desde la interfaz gráfica del IDE.

Si se tiene algún inconveniente con la ejecución, asegúrarse de que las variables de entorno de Java y Maven estén correctamente configuradas y de estar ubicado en la carpeta correspondiente antes de ejecutar los comandos.


---