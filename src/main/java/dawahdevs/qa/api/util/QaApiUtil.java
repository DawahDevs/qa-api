package dawahdevs.qa.api.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class QaApiUtil {

	private static final Map<String, String> EXAMPLE_CONFIG_MAP;

	public static <I, O> void optionalMap(final I input, final Function<I, O> conversion, final Consumer<O> output) {
		Optional.ofNullable(input).map(conversion).ifPresent(output);
	}

	public static <I, O> O copyTo(final I in, final Supplier<O> supplier, final String... ignoreProperties) {
		O out = supplier.get();
		BeanUtils.copyProperties(in, out, ignoreProperties);
		return out;
	}

	public static <T> T optFindFirstInList(final List<T> input) {
		return Optional.ofNullable(input).map(List::stream).flatMap(Stream::findFirst).orElse(null);
	}

	static {
		Map<String, String> configMap = new HashMap<>();
		configMap.put("AA", "EXAMPLE 1");
		configMap.put("BB", "EXAMPLE 2");
		EXAMPLE_CONFIG_MAP = Collections.unmodifiableMap(configMap);
	}

}