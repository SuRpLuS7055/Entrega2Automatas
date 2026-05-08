## Entrega 2 del laboratorio de TAC por:

Enrique Galiana Fernández-Calvillo (50%) y Carlos Salgado Rojas (50%)

##    

> [!IMPORTANT]  
> Es necesario seguir las instrucciones de abajo para compilar el proyecto.
>
> 1. Puedes clonar el repositorio, descargarlo, o hacer un fork al mismo.
> 2. Una vez clonado, debes crear dos "Run Configurations":
>   
>         a. Primero, creamos el run configuration del lexer, con los siguientes argumentos:
>           -jar jflex-full-1.9.1.jar -d target/generated-sources/jflex/uclm/automatas src/main/jflex/lexer.flex
>   
>         b. Segundo, el run configuration de CUP con los siguientes argumentos:
>           -jar java-cup-11b.jar -package uclm.automatas -parser Parser -symbols sym -destdir target/generated-sources/cup/uclm/automatas src/main/cup/parser.cup
>
> Recuerda tener ambos .jar (java-cup-11b.jar y jflex-full-1.9.1.jar) importados al proyecto para que funcione todo correctamente.
>   
>
> 4. Primero ejecutamos el Run Configuration del lexer, y segundo, ejecutamos el del CUP. Esto nos creará archivos .java necesarios para poder ejecutar el Main.java
> 5. Si todo ha funcionado bien, podrás ejecutar el Main.java. Este te generará un archivo "salida.dot"
> 6. Para visualizar "salida.dot", necesitarás el programa GraphViz.
