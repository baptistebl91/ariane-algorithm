# Répertoire de sortie
SRC_DIR = src
# Répertoire contenant les sources
OUT_DIR = build
# Obtention d'une liste des fichiers .java à compiler.
SRCS := $(wildcard $(SRC_DIR)/*.java)
# Création d'une liste des fichiers .class correspondant aux fichiers .java
CLS := $(SRCS:$(SRC_DIR)/%.java=$(OUT_DIR)/%.class)

.SUFFIXES: .java
# Ajout des règles qui ne créent pas de fichiers portant le même nom qu'elles.
.PHONY: build clean run
# Règle build qui appelle des règles de compilation pour chaque classe du projet.
make: $(CLS)
# Règle de compilation pour chaque fichier .java en fichier .class.
$(CLS): $(OUT_DIR)/%.class: $(SRC_DIR)/%.java
	javac -encoding utf8 -implicit:none -d $(OUT_DIR)/ -classpath $(SRC_DIR)/ $<
# Règle run qui construit le programme et exécute la classe Main.
run: make
	java -classpath $(OUT_DIR) Main
# Règle clean qui supprime l'ensemble des fichiers .class.
clean:
	$(RM) -r $(OUT_DIR)