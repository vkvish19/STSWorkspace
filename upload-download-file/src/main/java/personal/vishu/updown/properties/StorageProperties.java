package personal.vishu.updown.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties
{
    //folder location for storage location
    private String location = "F:\\STSWorkspace\\upload-download-file\\upload-dir";

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
}
