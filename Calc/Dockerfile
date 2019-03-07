FROM thyrlian/android-sdk
COPY ./app /app/app
COPY build.gradle /app
COPY gradle.properties /app
COPY settings.gradle /app
WORKDIR /app
CMD ["gradle", "test", "--no-daemon"]
