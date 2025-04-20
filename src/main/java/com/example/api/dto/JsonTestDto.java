package com.example.api.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public record JsonTestDto(
    String firstName,               // 名前（名）
    String lastName,                // 名前（姓）
    int age,                        // 年齢
    LocalDate dateOfBirth,          // 生年月日
    Gender gender,                  // 性別（Enum）
    String email,                   // メールアドレス
    String phoneNumber,             // 電話番号
    String address,                 // 住所
    boolean isEmployed,             // 雇用状態
    LocalDateTime lastLogin,        // 最後のログイン日時
    List<String> hobbies,           // 趣味のリスト
    Map<String, String> socialLinks, // ソーシャルメディアリンク
    List<String> languagesSpoken,   // 話せる言語
    String profilePictureUrl,       // プロフィール画像URL
    double height,                  // 身長
    double weight,                  // 体重
    String nationality,             // 国籍
    String maritalStatus,           // 婚姻状況
    String occupation,              // 職業
    String company,                 // 勤務先
    String educationLevel,          // 学歴
    List<String> previousEmployers, // 過去の雇用者
    boolean hasDriverLicense,       // 運転免許の有無
    String emergencyContact,        // 緊急連絡先
    String bloodType,               // 血液型
    String religion,                // 宗教
    LocalDateTime createdAt,        // 作成日時
    LocalDateTime updatedAt         // 更新日時
) {
    public enum Gender {
        MALE, FEMALE, NON_BINARY, OTHER
    }
}
