package de.saxsys.swing2javafx.model;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

/**
 * Class to load the license csv data.
 * 
 * @author daniel.winter
 * 
 */
public class CsvLicenseImporter {

    /**
     * Load the license data of the given csv file name/path.
     * 
     * @param csvLicensePath name/path of the csv file.
     * @return List with the license data
     * @throws LicenseLoadingException if a license could not load
     */
    public List<LicenseModel> importCsvLicences(final String csvLicensePath) {
        final List<LicenseModel> licenceModels = new ArrayList<>();

        try (ICsvBeanReader beanReader =
                new CsvBeanReader(new InputStreamReader(this.getClass().getResourceAsStream(csvLicensePath)),
                        CsvPreference.STANDARD_PREFERENCE)) {
            final String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = this.getProcessors();

            LicenseModel licence;
            while ((licence = beanReader.read(LicenseModel.class, header, processors)) != null) {
                licenceModels.add(licence);
            }
        } catch (final IOException e) {
            
        }
        return licenceModels;
    }

    private CellProcessor[] getProcessors() {
        final CellProcessor[] processors =
                new CellProcessor[] {new NotNull(), new NotNull(), new NotNull(), new NotNull(), new NotNull() };
        return processors;
    }
}
