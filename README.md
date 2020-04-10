# Benfords Law

This application will determine whether or not a file containing a large distribution of positive integers conforms to [Benfords Law](https://en.wikipedia.org/wiki/Benford%27s_law) or not. 

### Development

#### Requirements

 * Java 1.8

#### Running the application

If you don't have Java setup locally and just want to run the application

```
docker run -it --rm -v $PWD:/app -w /app mozilla/sbt sbt "run sampleData.txt"
```

If you have Java 1.8 then you can run the application as follows
 
```
sbt "run sampleData.txt"
```

#### Packaging the application up

```
sbt stage
```

This will package the application up with executable scripts

```
./target/universal/stage/bin/benfords-law sampleData.txt
```

Output

```
./target/universal/stage/bin/benfords-law sampleData.txt
Success!  Conforms to Benfords Law
```

#### Running tests

To run all tests 
```
sbt test
```

Or, from Docker

```
docker run -it --rm -v $PWD:/app -w /app mozilla/sbt sbt test
```