# TobLabaC launcher heap limit

Parent script (`/mnt/cabal/Cabal/toblabac.sh`, outside this repo) must source `java-opts.sh` and pass `TOBLABAC_JAVA_OPTS` on the Java command line.

Default heap is `-Xmx1g`. Override with space-separated simple JVM flags, e.g. `TOBLABAC_JAVA_OPTS=-Xmx768m`.

Expected fragment before `exec`:

```bash
source "$APP/java-opts.sh"
exec "$JAVA" \
  --module-path "$SDK/lib" \
  --add-modules javafx.controls,javafx.fxml,javafx.swing \
  $TOBLABAC_JAVA_OPTS \
  -cp "$CP" \
  control.TobLaba
```

`$TOBLABAC_JAVA_OPTS` is intentionally unquoted so a single flag like `-Xmx1g` expands as one token; keep values to space-separated simple JVM flags.
