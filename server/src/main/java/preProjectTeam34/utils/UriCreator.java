package preProjectTeam34.utils;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class UriCreator {
    public static URI createUri(String defaultUrl, long resourceId) {
        return UriComponentsBuilder
                .newInstance()
                .path(defaultUrl + "/{resource-id}")
                .buildAndExpand(resourceId)
                .toUri();
    }

    public static URI createUri(String defaultUrl, long resourceId, String resourceName) {
        return UriComponentsBuilder
                .newInstance()
                .path(defaultUrl + "/{resource-id}/{resource-name}")
                .buildAndExpand(resourceId, resourceName)
                .toUri();
    }
}
