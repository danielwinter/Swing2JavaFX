package de.saxsys.swing2javafx.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Data model to hold the license information of the csv data.
 * 
 * @author daniel.winter
 * 
 */
public class LicenseModel {

    private SimpleStringProperty libraryName;
    private SimpleStringProperty libraryVersion;
    private SimpleStringProperty mavenLibraryName;
    private SimpleStringProperty licenseName;
    private SimpleStringProperty licenseUrl;

    /**
     * Default constructor for the super csv framework.
     */
    public LicenseModel() {
        // need for the super csv framework
    }

    /**
     * Constructor.
     * 
     * @param libraryName Name of the library.
     * @param libraryVersion Version of the library.
     * @param mavenLibraryName Name of the maven library.
     * @param licenceName Name of the license.
     * @param licenceUrl URL to the license text.
     */
    public LicenseModel(final String libraryName, final String libraryVersion, final String mavenLibraryName,
            final String licenceName, final String licenceUrl) {
        this.libraryName = new SimpleStringProperty(libraryName);
        this.libraryVersion = new SimpleStringProperty(libraryVersion);
        this.mavenLibraryName = new SimpleStringProperty(mavenLibraryName);
        this.licenseName = new SimpleStringProperty(licenceName);
        this.licenseUrl = new SimpleStringProperty(licenceUrl);
    }

    /**
     * Set the library name.
     * 
     * @param libraryName Name of the library.
     */
    public void setLibraryName(final String libraryName) {
        this.libraryName = new SimpleStringProperty(libraryName);
    }

    /**
     * Set the version of the library.
     * 
     * @param libraryVersion Version of the library.
     */
    public void setLibraryVersion(final String libraryVersion) {
        this.libraryVersion = new SimpleStringProperty(libraryVersion);
    }

    /**
     * Set the name of the maven library.
     * 
     * @param mavenLibraryName Name of the maven library.
     */
    public void setMavenLibraryName(final String mavenLibraryName) {
        this.mavenLibraryName = new SimpleStringProperty(mavenLibraryName);
    }

    /**
     * Set the name of the license.
     * 
     * @param licenceName Name of the license.
     */
    public void setLicenseName(final String licenceName) {
        this.licenseName = new SimpleStringProperty(licenceName);
    }

    /**
     * Set the url to the license text.
     * 
     * @param licenceUrl URL to the license text.
     */
    public void setLicenseUrl(final String licenceUrl) {
        this.licenseUrl = new SimpleStringProperty(licenceUrl);
    }

    /**
     * Returns the name of the library.
     * 
     * @return Name of the library.
     */
    public String getLibraryName() {
        return this.libraryName.get();
    }

    /**
     * Returns the version of the library.
     * 
     * @return Version of the library.
     */
    public String getLibraryVersion() {
        return this.libraryVersion.get();
    }

    /**
     * Returns the maven name of the library.
     * 
     * @return maven name of the library.
     */
    public String getMavenLibraryName() {
        return this.mavenLibraryName.get();
    }

    /**
     * Returns the name of the license.
     * 
     * @return Name of the license.
     */
    public String getLicenseName() {
        return this.licenseName.get();
    }

    /**
     * Returns the url to the license text.
     * 
     * @return URL to the license text.
     */
    public String getLicenseUrl() {
        return this.licenseUrl.get();
    }

    /**
     * Returns the name of the library as property.
     * 
     * @return name of the library as property.
     */
    public SimpleStringProperty getLibraryNameProperty() {
        return this.libraryName;
    }

    /**
     * Returns the version of the library as property.
     * 
     * @return version of the library as property.
     */
    public SimpleStringProperty getLibraryVersionProperty() {
        return this.libraryVersion;
    }

    /**
     * Returns the maven name of the library as property.
     * 
     * @return maven name of the library as property.
     */
    public SimpleStringProperty getMavenLibraryNameProperty() {
        return this.mavenLibraryName;
    }

    /**
     * Returns the license name as property.
     * 
     * @return license name as property.
     */
    public SimpleStringProperty getLicenseNameProperty() {
        return this.licenseName;
    }

    /**
     * Returns the url to the license text as property.
     * 
     * @return url to the license text as property.
     */
    public SimpleStringProperty getLicenseUrlProperty() {
        return this.licenseUrl;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.libraryName == null) ? 0 : libraryName.hashCode());
        result = prime * result + ((this.libraryVersion == null) ? 0 : libraryVersion.hashCode());
        result = prime * result + ((this.licenseName == null) ? 0 : licenseName.hashCode());
        result = prime * result + ((this.licenseUrl == null) ? 0 : licenseUrl.hashCode());
        result = prime * result + ((this.mavenLibraryName == null) ? 0 : mavenLibraryName.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LicenseModel [libaryName=" + this.libraryName + ", libaryversion=" + this.libraryVersion
                + ", mavenLibaryName=" + this.mavenLibraryName + ", licenseName=" + this.licenseName + ", licenseUrl="
                + this.licenseUrl + "]";
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LicenseModel other = (LicenseModel) obj;
        if (libraryName == null) {
            if (other.libraryName != null) {
                return false;
            }
        } else if (!libraryName.equals(other.libraryName)) {
            return false;
        }
        if (libraryVersion == null) {
            if (other.libraryVersion != null) {
                return false;
            }
        } else if (!libraryVersion.equals(other.libraryVersion)) {
            return false;
        }
        if (licenseName == null) {
            if (other.licenseName != null) {
                return false;
            }
        } else if (!licenseName.equals(other.licenseName)) {
            return false;
        }
        if (licenseUrl == null) {
            if (other.licenseUrl != null) {
                return false;
            }
        } else if (!licenseUrl.equals(other.licenseUrl)) {
            return false;
        }
        if (mavenLibraryName == null) {
            if (other.mavenLibraryName != null) {
                return false;
            }
        } else if (!mavenLibraryName.equals(other.mavenLibraryName)) {
            return false;
        }
        return true;
    }
}
