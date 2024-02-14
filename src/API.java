public enum API {
    IMDB_TOP_MOVIES("https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060", new ExtratorDeConteudoDoIMDB()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14",
            new ExtratorDeConteudoDaNasa());

    private String url;
    private ExtratorDeConteudo extrator;

    API(String url, ExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public ExtratorDeConteudo getExtrator() {
        return extrator;
    }
}
