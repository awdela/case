package com.test.mustache;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

public class MustacheTest {

    List<Item> items() {
        return Arrays.asList(
          new Item("Item 1", "$19.99", Arrays.asList(new Feature("New!"), new Feature("Awesome!"))),
          new Item("Item 2", "$29.99", Arrays.asList(new Feature("Old."), new Feature("Ugly.")))
        );
      }

      static class Item {
        Item(String name, String price, List<Feature> features) {
          this.name = name;
          this.price = price;
          this.features = features;
        }

        String name, price;
        List<Feature> features;
      }

      static class Feature {
        Feature(String description) {
          this.description = description;
        }

        String description;
      }

      public static void main(String[] args) throws IOException {
          HashMap<String, Object> scopes = new HashMap<String, Object>();
          scopes.put("name", "Mustache");
          scopes.put("feature", new Feature("Perfect!"));
          Writer writer = new StringWriter();
          MustacheFactory mf = new DefaultMustacheFactory();
          Mustache mustache = mf.compile(new StringReader("asdfs{{name}}, asdas{{feature.description}}!"), "");
          mustache.execute(writer, scopes);
          writer.flush();
          System.out.println(writer.toString());
      }

}
