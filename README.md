# Examen DevOps - MVC

## Instrucciones de Ejecución 
1. Clonar el repositorio.
2. Abrir una terminal en la raíz del proyecto.
3. Ejecutar el comando para Linux/Mac: `./gradlew bootRun` o para Windows: `.\gradlew.bat bootRun`.
4. Acceder a la aplicación web en: `http://localhost:8080/`.
5. Probar API JSON:
   - POST: `http://localhost:8080/estudiantes` (Body raw JSON)
   - GET: `http://localhost:8080/estudiantes`

## Estrategia de Versionamiento (GitOps) 
 **Opción B (GitFlow)**. 
- **Justificación:** Esta estrategia permite un desarrollo seguro aislada en la rama `develop`, asegurando que la rama `main` siempre contenga una versión estable y lista para producción. Las funcionalidades se integran mediante Pull Requests.

## Herramientas del Pipeline (CI/CD) 
- **GitHub Actions:** Orquestador del flujo de trabajo.
- **Gradle:** Herramienta de construcción y gestión de dependencias.
- **Softprops Release Action:** Acción automatizada para generar releases en GitHub tras un merge exitoso a `main`.