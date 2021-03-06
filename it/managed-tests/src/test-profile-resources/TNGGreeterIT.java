/**
 * (C) Copyright IBM Corporation 2017, 2018.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.arquillian.example.Greeter;
import org.arquillian.example.PhraseBuilder;

import java.io.File;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TNGGreeterIT extends Arquillian {

	@Deployment
    public static WebArchive createDeployment() {
        WebArchive archive = ShrinkWrap.create(WebArchive.class).addClasses(Greeter.class, PhraseBuilder.class);
        System.out.println(archive.toString());
        return archive;
    }

	@Inject
    Greeter greeter;

    @Test
    public void should_create_greeting() {
        String greeting = greeter.createGreeting("Earthling");
        Assert.assertEquals("Hello, Earthling!", greeting);
        greeter.greet(System.out, "Earthling");
    }

}
