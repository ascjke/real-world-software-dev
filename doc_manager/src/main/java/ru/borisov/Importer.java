package ru.borisov;

import java.io.File;
import java.io.IOException;

interface Importer {
    Document importFile(final File file) throws IOException;
}
