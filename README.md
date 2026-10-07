# AppGrupo3 — Examen T2

Aplicación Android desarrollada para el examen T2 de la carrera. La app inicia con una
pantalla de **login** (usuarios de prueba del grupo) y al validar correctamente pasa a un
**Home** con un menú inferior de 4 preguntas.

## Integrantes

- Omar Yañez
- Liliana Cuhero
- Emilio Lopez
- Cesar Vilcarromero
- Leonardo David
- Franco Cossio
- Gustavo

## Flujo de trabajo

1. Cada colaborador levantó su propia rama (`feature/...`) e implementó su parte del
   examen de forma independiente.
2. Se creó una rama local `resolution-merge`, donde se integraron todas las ramas y se
   resolvieron los conflictos de código (navegación, fragments, layouts, dependencias)
   siguiendo un mismo estándar de nombres y estructura.
3. Finalmente se hizo el merge de `resolution-merge` hacia `main` para la entrega.

## Funcionalidades

| Pestaña | Descripción |
|---------|-------------|
| Pregunta 1 | Cálculo del consumo de agua |
| Pregunta 2 | Cálculo del consumo de energía (recargo por exceso) |
| Pregunta 3 | Lista de 20 obras literarias peruanas (RecyclerView + Glide) |
| Pregunta 4 | Listado de usuarios consumiendo una API REST con Retrofit |

## Tecnologías

- Kotlin, Android Studio
- ViewBinding, Material 3
- RecyclerView, Glide
- Retrofit + Gson (dummyjson.com)
