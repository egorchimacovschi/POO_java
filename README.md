# POO_java

Java exercises from my Object-Oriented Programming (POO) course at ACS, UPB.
Each laboratory is a folder of small, self-contained problems.

## Structure

```
learning/
├── laboratory1 … laboratory4   # Java basics, classes, objects
├── laboratory5                 # Custom data structures (stack, list, graph, vector), inheritance
├── laboratory6                 # Abstract classes, interfaces, generics, comparators
├── laboratory7                 # Collections, file input, LRU cache
└── laboratory8                 # Generic collections: ArrayMap, LinkedList, inner classes
```

Each problem folder has its own `Makefile`. Labs 1–4 keep the problems together in one folder.

## Requirements

- JDK 11 or newer (`javac`, `java`)
- `make`

## Build and run

```bash
cd learning/laboratory8/Problema1
make            # compile every .java file
java Task1      # run the class that has main()
make clean      # remove .class files
```

If you don't have `make`, compile directly: `javac *.java`.

## Notes

- The entry point differs by problem (`Test*.java`, `Task*.java`, `Main.java` or `ProblemaN.java`). Look for the file with `public static void main`.
- Some problems read input from the `.txt` files in their folder.
