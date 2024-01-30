# SpringMVCWithBoot
    Spring MVC project with using Spring Boot and JPA where AlienController is @RestController and responsible for following REST APIs
# cURLs
<ol>
    <li>
        Get all aliens
        <ul>
            <li>curl --location 'localhost:8080/SpringMVCWithBoot/aliens'</li>
        </ul>
    </li>
    <li>
        Get alien by id
        <ul>
            <li>curl --location 'localhost:8080/SpringMVCWithBoot/alien/102'</li>
        </ul>
    </li>
    <li>
        Add alien
        <ul>
            <li>
                curl --location 'localhost:8080/SpringMVCWithBoot/alien' \
                --header 'Content-Type: application/x-www-form-urlencoded' \
                --data-urlencode 'aid=115' \
                --data-urlencode 'aname=ABC'
            </li>
        </ul>
    </li>
</ol>