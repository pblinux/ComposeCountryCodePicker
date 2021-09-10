# Compose Country Code Picker
Country code picker for Jetpack Compose.

## Install
In the `build.gradle` add maven central repository
```
repositories {
    mavenCentral()
}
```
Then, add library at `app/build.gradle` with following code
```
implementation 'com.sinaukoding:cccp:1.0.0'
```

## How to use ?

```kotlin
CountryCodeDialog(pickedCountry = { 
    Log.d("", it.name) // picked contry name
})

```

## Preview

## License
```
 Apache License
                           Version 2.0, January 2004
                        http://www.apache.org/licenses/

   TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION

   1. Definitions.

      "License" shall mean the terms and conditions for use, reproduction,
      and distribution as defined by Sections 1 through 9 of this document.

      "Licensor" shall mean the copyright owner or entity authorized by
      the copyright owner that is granting the License.

      "Legal Entity" shall mean the union of the acting entity and all
      other entities that control, are controlled by, or are under common
      control with that entity. For the purposes of this definition,
      "control" means (i) the power, direct or indirect, to cause the
      direction or management of such entity, whether by contract or
      otherwise, or (ii) ownership of fifty percent (50%) or more of the
      outstanding shares, or (iii) beneficial ownership of such entity.
```