package de.saxsys.swing2javafx.model;

/**
 * Information which are displayed at the about/license pane.
 * 
 * @author daniel.winter
 */
@SuppressWarnings("PMD.CyclomaticComplexity")
public class AboutInformation {

    private String trademark;
    private String address;
    private String registryNumber;
    private String version;

    /**
     * Constructor.
     * 
     * @param trademark trademark at the bottom line of the pane.
     * @param address address of saxonia.
     * @param registryNumber registry number of the app.
     * @param version version of the app.
     */
    public AboutInformation(final String trademark, final String address, final String registryNumber,
            final String version) {
        this.trademark = trademark;
        this.address = address;
        this.registryNumber = registryNumber;
        this.version = version;
    }

    /**
     * Returns the trademark.
     * 
     * @return trademark
     */
    public String getTrademark() {
        return this.trademark;
    }

    /**
     * Set the trademark.
     * 
     * @param trademark trademark
     */
    public void setTrademark(final String trademark) {
        this.trademark = trademark;
    }

    /**
     * Returns the address.
     * 
     * @return address.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Set the address.
     * 
     * @param address address
     */
    public void setAddress(final String address) {
        this.address = address;
    }

    /**
     * Returns the registry number.
     * 
     * @return registry number
     */
    public String getRegistryNumber() {
        return this.registryNumber;
    }

    /**
     * Set the registry number.
     * 
     * @param registryNumber registry number
     */
    public void setRegistryNumber(final String registryNumber) {
        this.registryNumber = registryNumber;
    }

    /**
     * Returns the version.
     * 
     * @return version.
     */
    public String getVersion() {
        return this.version;
    }

    /**
     * Set the version.
     * 
     * @param version version
     */
    public void setVersion(final String version) {
        this.version = version;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    @SuppressWarnings("PMD.NPathComplexity")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.address == null) ? 0 : this.address.hashCode());
        result = prime * result + ((this.registryNumber == null) ? 0 : this.registryNumber.hashCode());
        result = prime * result + ((this.trademark == null) ? 0 : this.trademark.hashCode());
        result = prime * result + ((this.version == null) ? 0 : this.version.hashCode());
        return result;
    }

    // CHECKSTYLE:OFF
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    @SuppressWarnings({"PMD.NPathComplexity", "PMD.CyclomaticComplexity" })
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
        final AboutInformation other = (AboutInformation) obj;
        if (this.address == null) {
            if (other.address != null) {
                return false;
            }
        } else if (!this.address.equals(other.address)) {
            return false;
        }
        if (this.registryNumber == null) {
            if (other.registryNumber != null) {
                return false;
            }
        } else if (!this.registryNumber.equals(other.registryNumber)) {
            return false;
        }
        if (this.trademark == null) {
            if (other.trademark != null) {
                return false;
            }
        } else if (!this.trademark.equals(other.trademark)) {
            return false;
        }
        if (this.version == null) {
            if (other.version != null) {
                return false;
            }
        } else if (!this.version.equals(other.version)) {
            return false;
        }
        return true;
    }

    // CHECKSTYLE:ON

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AboutInformation [trademark=" + this.trademark + ", address=" + this.address + ", registryNumber="
                + this.registryNumber + ", version=" + this.version + "]";
    }
}
