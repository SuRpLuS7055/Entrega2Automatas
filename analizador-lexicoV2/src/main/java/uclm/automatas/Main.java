package uclm.automatas;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
  public static void main(String[] args) throws Exception {

    if (args.length > 0) {
      Path entrada = Paths.get(args[0]);

      try (Reader r = Files.newBufferedReader(entrada, StandardCharsets.UTF_8)) {
        Lexer lexer = new Lexer(r);
        Parser parserObj = new Parser(lexer);
        parserObj.parse();

        if (parserObj.salidaDot == null) {
          throw new IllegalStateException("No se ha generado salida DOT");
        }

        String nombre = entrada.getFileName().toString();
        int punto = nombre.lastIndexOf('.');
        if (punto != -1) {
          nombre = nombre.substring(0, punto);
        }

        Path salida = entrada.resolveSibling(nombre + ".dot");
        Files.write(salida, parserObj.salidaDot.getBytes(StandardCharsets.UTF_8));

        System.out.println("Fichero DOT generado en: " + salida.toAbsolutePath());
      }
      return;
    }

    try (InputStream in = Main.class.getClassLoader().getResourceAsStream("input.txt")) {
      if (in == null) {
        throw new IllegalStateException("No encuentro input.txt en src/main/resources");
      }

      try (Reader r = new InputStreamReader(in, StandardCharsets.UTF_8)) {
        Lexer lexer = new Lexer(r);
        Parser parserObj = new Parser(lexer);
        parserObj.parse();

        if (parserObj.salidaDot == null) {
          throw new IllegalStateException("No se ha generado salida DOT");
        }

        Path salida = Paths.get("salida.dot");
        Files.write(salida, parserObj.salidaDot.getBytes(StandardCharsets.UTF_8));

        System.out.println("Fichero DOT generado en: " + salida.toAbsolutePath());
      }
    }
  }
}