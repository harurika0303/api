package com.example.api.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.example.api.dto.JsonTestDto;

@Component
public class DummyDataGenerator {

    public List<JsonTestDto> get(int itemCount) {
        List<JsonTestDto> dummyData = new ArrayList<>();
        
        for (int i = 0; i < itemCount; i++) {
            JsonTestDto dummy = generateRandomData(i);
            dummyData.add(dummy);
        }

        // ダミーデータを出力
        // dummyData.forEach(System.out::println);

        return dummyData;
    }

    private static JsonTestDto generateRandomData(int index) {
        Random random = new Random();
        String[] firstNames = {"John", "Jane", "Alice", "Bob", "Charlie", "David", "Eve", "Grace", "Harry", "Ivy"};
        String[] lastNames = {"Smith", "Johnson", "Brown", "Taylor", "Davis", "Wilson", "Moore", "Anderson", "Thomas", "Jackson"};
        String[] emails = {"email1@example.com", "email2@example.com", "email3@example.com", "email4@example.com", "email5@example.com"};
        String[] phoneNumbers = {"080-1234-5678", "090-2345-6789", "080-3456-7890", "090-4567-8901", "080-5678-9012"};
        String[] addresses = {"Tokyo", "Osaka", "Kyoto", "Hokkaido", "Fukuoka"};
        String[] hobbies = {"Reading", "Traveling", "Cooking", "Gaming", "Sports"};
        String[] languages = {"Japanese", "English", "Chinese", "Spanish"};
        String[] previousEmployers = {"Company A", "Company B", "Company C"};
        
        JsonTestDto.Gender gender = JsonTestDto.Gender.values()[random.nextInt(JsonTestDto.Gender.values().length)];
        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        String email = emails[random.nextInt(emails.length)];
        String phoneNumber = phoneNumbers[random.nextInt(phoneNumbers.length)];
        String address = addresses[random.nextInt(addresses.length)];
        List<String> hobbiesList = Arrays.asList(hobbies[random.nextInt(hobbies.length)], hobbies[random.nextInt(hobbies.length)]);
        Map<String, String> socialLinks = new HashMap<>();
        socialLinks.put("Twitter", "https://twitter.com/user" + index);
        socialLinks.put("Instagram", "https://instagram.com/user" + index);
        List<String> languagesSpoken = Arrays.asList(languages[random.nextInt(languages.length)], languages[random.nextInt(languages.length)]);
        String profilePictureUrl = "https://example.com/profile" + index + ".jpg";
        
        return new JsonTestDto(
            firstName,
            lastName,
            random.nextInt(50) + 20, // 年齢は20-69歳
            LocalDate.of(random.nextInt(50) + 1970, random.nextInt(12) + 1, random.nextInt(28) + 1),
            gender,
            email,
            phoneNumber,
            address,
            random.nextBoolean(),
            LocalDateTime.now().minusDays(random.nextInt(30)),
            hobbiesList,
            socialLinks,
            languagesSpoken,
            profilePictureUrl,
            random.nextDouble() * 100 + 150,  // 身長は150-250cm
            random.nextDouble() * 40 + 40,    // 体重は40-80kg
            "Japan",
            random.nextBoolean() ? "Single" : "Married",
            "Software Engineer",
            "Tech Corp",
            "Bachelor's Degree",
            Arrays.asList(previousEmployers[random.nextInt(previousEmployers.length)], previousEmployers[random.nextInt(previousEmployers.length)]),
            random.nextBoolean(),
            phoneNumbers[random.nextInt(phoneNumbers.length)],
            "A",
            "No religion",
            LocalDateTime.now(),
            LocalDateTime.now()
        );
    }
}
