# Proyecto Final DPOO - Control de la Actividad Investigativa

Sistema de escritorio en Java (Swing) para gestionar la actividad investigativa y de posgrado de una facultad, modelada desde un **vicedecanato**.

## ¿Qué hace este proyecto?

La aplicación permite:

- Gestionar **docentes**, **estudiantes** y **departamentos**.
- Organizar líneas de investigación y sus integrantes.
- Registrar resultados investigativos:
  - artículos,
  - capítulos de libro,
  - ponencias en eventos.
- Calcular puntajes investigativos y generar rankings.
- Gestionar cursos de posgrado y maestrías:
  - cursos impartidos y recibidos,
  - créditos acumulados,
  - emisión de notas,
  - validación de visto bueno para defensa de maestría.
- Autenticación básica con login/registro de usuarios usando archivo local.

## Estructura del repositorio

- `Proyecto Final 4 DPOO/`
  - Proyecto Java principal (estructura Eclipse).
  - `src/Principal`: punto de entrada de la app (`Inicializadora.java`).
  - `src/Login`: login, registro y persistencia simple de usuarios (`usuarios.txt`).
  - `src/Interfaz`: ventanas y diálogos Swing.
  - `src/Logica`: modelo del dominio y reglas de negocio.
  - `src/Excepciones`: excepciones personalizadas.
  - Librerías externas incluidas:
    - `jcalendar-1.4.jar`
    - `miglayout15-swing.jar`
- `Documentacion del Proyecto/`
  - documentación en PDF y DOCX.
- `Diagrama de clases/`
  - diagrama UML del sistema.
- `Archivos de soporte/`
  - recursos auxiliares (imágenes/código de apoyo).

## Cómo ejecutar

1. Abrir la carpeta `Proyecto Final 4 DPOO` como proyecto Java en Eclipse.
2. Verificar que el Build Path incluya las librerías `.jar` incluidas en esa carpeta.
3. Ejecutar la clase:
   - `Principal.Inicializadora`

## Notas importantes

- El proyecto usa una estructura clásica de Eclipse (`.project`, `.classpath`).
- La clase `Inicializadora` carga datos iniciales para probar el sistema (incluye un volumen alto de docentes y datos de ejemplo).
- El archivo `usuarios.txt` se usa para almacenar credenciales de forma local.
