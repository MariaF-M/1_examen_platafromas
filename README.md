# Examen DevOps - MVC

## Instrucciones de Ejecución 

Este proyecto sigue estrictamente la estrategia **GitFlow**, por lo que el despliegue y la ejecución deben respetar el ciclo de vida de las ramas.

### 1. Gestión del Código (GitFlow)
Para interactuar correctamente con este repositorio y respetar la estrategia de versionamiento:

1.  **Crear el repositorio:**
    Se crea un GitHub directamente y el comando para conectarlo es:
    ```bash
    git remote add origin https://github.com/MariaF-M/1_examen_platafromas.git
    ```
2.  **Cambiar a la rama de desarrollo:**
    El código fuente activo se encuentra en la rama `develop`. La rama `main` está reservada únicamente para producción.
    ```bash
    git checkout develop
    ```
3.  **Flujo de Trabajo:**
    * No se permiten *commits* directos a `main`.
    * Toda nueva funcionalidad o corrección se trabaja en `develop` (o *feature branches*).
    * Para llevar cambios a producción, se debe crear un **Pull Request** desde `develop` hacia `main`.
    * **Automáticamente:** Al aprobarse el Pull Request, el pipeline de **GitHub Actions** compilará el proyecto y generará un **Release** con la nueva versión.

### 2. Ejecución Local
Una vez clonado el proyecto y ubicados en la rama `develop`, sigue estos pasos para levantar el servidor:

1.  **Limpiar y Construir (Recomendado):**
    ```bash 
    .\gradlew.bat clean build 
    ````

2.  **Iniciar la Aplicación:**
    ```bash 
    .\gradlew.bat bootRun
    ```` 

    > **Nota:** Esperar hasta ver en la consola el mensaje: `Started DevopsApplication in...`.

### 3. Verificación y Pruebas
Con el servidor corriendo, puedes probar los dos componentes de la arquitectura MVC:

* **Frontend (Vista HTML):**
    * Acceder a: `http://localhost:6001/`
    * Permite registrar estudiantes mediante formulario y visualizar la lista en memoria.

* **Backend (API REST):**
    * **POST** `/estudiantes`: Recibe JSON `{"id": "...", "nombre": "...", "carrera": "..."}`. 
    * **GET** `/estudiantes`: Retorna la lista completa en formato JSON. 
---
## Estrategia de Versionamiento (GitOps) 
 **Opción B (GitFlow)**. 
- **Justificación:** Esta estrategia permite un desarrollo seguro aislada en la rama `develop`, asegurando que la rama `main` siempre contenga una versión estable y lista para producción. Las funcionalidades se integran mediante Pull Requests.
---

## Herramientas del Pipeline (CI/CD) 
- **GitHub Actions:** Orquestador del flujo de trabajo.
- **Gradle:** Herramienta de construcción y gestión de dependencias.
- **Softprops Release Action:** Acción automatizada para generar releases en GitHub tras un merge exitoso a `main`.
---

## Historial de Comandos Ejecutados

A continuación se presenta el registro completo y secuencial de los comandos utilizados para la configuración, desarrollo y despliegue del proyecto, demostrando la implementación de GitFlow y la conexión remota.

```bash
# --- 1. Configuración Inicial del Entorno ---
git --version
git init
git config --global user.name "MariaF-M"
git config --global user.email "mafe.munoz.acosta@gmail.com"

# --- 2. Implementación de GitFlow (Ramas Base) ---
# Creación de rama main (Producción)
git checkout -b main
git add .
git commit -m "1"

# Creación de rama develop (Desarrollo)
git checkout -b develop

# --- 3. Desarrollo y Registro de Cambios ---
# Iteración: Controller
git add .
git commit -m "2 Ajuste en el Controller"

# Iteración: Vistas (Parte 1)
git add .
git commit -m "3 Ajuste vista"

# Iteración: Vistas (Parte 2)
git add .
git commit -m "4 Ajuste vista"

# --- 4. Sincronización y Despliegue Remoto ---
# Conexión con GitHub
git remote add origin [https://github.com/MariaF-M/1_examen_platafromas.git](https://github.com/MariaF-M/1_examen_platafromas.git)

# Subida de rama de desarrollo
git push -u origin develop

# Subida de rama principal
git checkout main
git push -u origin main

# Retorno a rama de trabajo
git checkout develop
