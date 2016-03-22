/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.buddyappz.backend;

import com.example.JokesFactory;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.buddyappz.com",
    ownerName = "backend.buddyappz.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that provide a joke back */
    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();
        JokesFactory jokes = new JokesFactory();

        response.setData(jokes.getJoke());


        /* ...for Progressbar testing purposes...
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */

        return response;
    }

}
