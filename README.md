### Hexlet tests and linter status:
[![Actions Status](https://github.com/Ymirotvorenie/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Ymirotvorenie/java-project-78/actions)
[![Java CI](https://github.com/Ymirotvorenie/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/Ymirotvorenie/java-project-78/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/03f78ee94e068afd9290/maintainability)](https://codeclimate.com/github/Ymirotvorenie/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/03f78ee94e068afd9290/test_coverage)](https://codeclimate.com/github/Ymirotvorenie/java-project-78/test_coverage)

# Data Validator

## Usage Example
~~~
var v = new Validator();
var schema = v.map();
Map<String, BaseSchema<String>> schemas = new HashMap<>();

// Определяем схемы валидации для значений свойств "firstName" и "lastName"
// Имя должно быть строкой, обязательно для заполнения
schemas.put("firstName", v.string().required());

// Фамилия обязательна для заполнения и должна содержать не менее 2 символов
schemas.put("lastName", v.string().required().minLength(2));

// Настраиваем схему `MapSchema`
// Передаем созданный набор схем в метод shape()
schema.shape(schemas);

// Проверяем объекты
Map<String, String> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
schema.isValid(human1); // true

Map<String, String> human2 = new HashMap<>();
human2.put("firstName", "John");
human2.put("lastName", null);
schema.isValid(human2); // false

Map<String, String> human3 = new HashMap<>();
human3.put("firstName", "Anna");
human3.put("lastName", "B");
schema.isValid(human3); // false
~~~

## Support methods

- `.required()` - Add NotNull check
    
- `.string()` - Set up String type validation:

  - `.minLength(int minLength)` - Add minimal length check
  - `.contains(String text)` - Add contains check

- `.number()` - Set up Integer type validation
    
    - `.positive()` - Add number > 0 check
    - `.range(int begin, int end)` - Add range check

- `.map()` - Set up Map<K, V> type validation
    
    - `.sizeof(int count)` - Add size check (map.EntrySet().size())
    - `.shape(Map<K, BaseSchema<V>> dataSchemas)` - Add recursive data check for all values

- `isValid(T object)` - Start validation
