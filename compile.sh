SOURCE_DIR="src"
DEST_DIR="dist"

if [ ! -d "$DEST_DIR" ]; then
    mkdir -p "$DEST_DIR"
fi

javac -d "$DEST_DIR" "$SOURCE_DIR"/*.java

echo "Kompilierung abgeschlossen."
